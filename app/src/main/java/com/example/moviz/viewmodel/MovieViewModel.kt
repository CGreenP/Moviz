package com.example.moviz.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviz.BuildConfig
import com.example.moviz.repository.Repository
import com.example.moviz.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var popularMovies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromAPI by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set


    init {
        viewModelScope.launch {
            try {

                val apiKey = BuildConfig.API_KEY
                moviesFromAPI = repository.getPopularMoviesFromOnlineApi(apiKey)

                repository.insertMoviesListToDB(moviesFromAPI)

                movies = moviesFromAPI

                popularMovies = movies.sortedByDescending { it.popularity }

            } catch (e: Exception) {
                Log.d("TAG", "MovieViewModel: ${e.message}")
                moviesFromRoomDB = repository.getPopularMoviesFromDB()
                movies = moviesFromRoomDB
                popularMovies = movies.sortedByDescending { it.popularity }
            }
        }
    }
}