package com.example.appgs.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appgs.Movie
import com.example.appgs.MovieClickListener
import com.example.appgs.MoviesAdapter
import com.example.appgs.databinding.FragmentHomeBinding

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
        binding.recycler.adapter = MoviesAdapter(
            listOf(
                Movie("Titulo 1", "https://loremflickr.com/320/240?lock=1"),
                Movie("Titulo 2", "https://loremflickr.com/320/240?lock=2"),
                Movie("Titulo 3", "https://loremflickr.com/320/240?lock=3"),
                Movie("Titulo 4", "https://loremflickr.com/320/240?lock=4"),
                Movie("Titulo 5", "https://loremflickr.com/320/240?lock=5"),
                Movie("Titulo 6", "https://loremflickr.com/320/240?lock=6")
            ),
            object : MovieClickListener{
                override fun onMovieClicked(movie: Movie) {
                    Toast
                        .makeText(activity, movie.title , Toast.LENGTH_SHORT)
                        .show()
                }

            }
        )
        //Termina codigo
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}