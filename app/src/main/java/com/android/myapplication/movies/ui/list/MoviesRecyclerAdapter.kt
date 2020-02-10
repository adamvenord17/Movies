package com.android.myapplication.movies.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.android.myapplication.movies.R
import com.android.myapplication.movies.databinding.MovieListItemBinding
import com.android.myapplication.popularmovies.api.model.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesRecyclerAdapter(private val onMovieClickListener: (Movie) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Movie, MoviesRecyclerAdapter.MovieViewHolder>(
        MovieDiffUtil()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.getInstance(parent, onMovieClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }


    class MovieViewHolder private constructor(
        private val binding: MovieListItemBinding
        ,val onMovieClickListener: (Movie) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            private const val TAG = "MovieViewHolder"
            fun getInstance(
                parent: ViewGroup,
                onMovieClickListener: (Movie) -> Unit
            ): MovieViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = MovieListItemBinding.inflate(inflater, parent, false)
                return MovieViewHolder(
                    binding,
                    onMovieClickListener
                )
            }
        }

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.viewHolder = this
        }


    }

    class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }
}