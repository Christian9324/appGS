package com.example.appgs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appgs.databinding.ViewMovieItemBinding
import com.example.appgs.model.Tv

class TvAdapter(
    var tv : List<Tv>,
    private val tvClickListener: (Tv) -> Unit
) : RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = tv[position]
        holder.bind(tv)
        holder.itemView.setOnClickListener(){
            tvClickListener(tv)
        }
    }

    override fun getItemCount(): Int = tv.size

    class ViewHolder(private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(tv : Tv){
            binding.title.text = tv.name
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500${tv.poster_path}")
                .into(binding.cover)
        }
    }
}