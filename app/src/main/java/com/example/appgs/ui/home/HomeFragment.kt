package com.example.appgs.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.appgs.MoviesAdapter
import com.example.appgs.R
import com.example.appgs.databinding.FragmentHomeBinding
import com.example.appgs.model.MovieDBClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Inicia codigo

        val moviesAdapter = MoviesAdapter( emptyList() ) { movie ->
            Toast
                .makeText(activity, movie.title, Toast.LENGTH_SHORT)
                .show()
        }

        binding.recycler.adapter = moviesAdapter

        lifecycleScope.launch {
            val apiKey = getString(R.string.api_key)
            val popularMovies = MovieDBClient.service.listPopularMovies(apiKey)
            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()
        }

//        thread {
//            val popularMovies = MovieDBClient.service.listPopularMovies(getString(R.string.api_key))
//            val body = popularMovies.execute().body()
//
//            activity?.runOnUiThread {
//                if(body != null){
////                    Log.d("HomeFragment", "Conteo de peliculas: ${body.results.size}")
//                    moviesAdapter.movies = body.results
//                    moviesAdapter.notifyDataSetChanged()
//                }
//            }
//        }
        //Termina codigo
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}