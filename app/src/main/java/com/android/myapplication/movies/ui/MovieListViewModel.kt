package com.android.myapplication.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.myapplication.movies.repository.MoviesRepository
import com.android.myapplication.movies.util.Categories
import com.android.myapplication.popularmovies.api.model.Movie

class MovieListViewModel(private val repository: MoviesRepository) : ViewModel() {

    var isPerformingQuery = false
    val movieList: LiveData<List<Movie>> = repository.movieList

    fun getMovies(pageNumber: Int, sortBy: Categories) {
        repository.getMovies(pageNumber, sortBy)
    }

    fun searchMovies(pageNumber: Int, query: String) {
        repository.searchMovies(pageNumber, query)
    }
}