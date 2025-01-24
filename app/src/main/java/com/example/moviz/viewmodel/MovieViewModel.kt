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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.onStart {
            loadData(repository = repository)
        }.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000L), false
        )

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var popularMovies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromAPI by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set

    fun loadData(repository: Repository) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val apiKey = BuildConfig.API_KEY
                moviesFromAPI = repository.getPopularMoviesFromOnlineApi(apiKey,1)

                repository.insertMoviesListToDB(moviesFromAPI)

                moviesFromRoomDB = repository.getPopularMoviesFromDB()
                movies = moviesFromRoomDB

                popularMovies = movies.sortedByDescending { it.popularity }
                _isLoading.value = false

            } catch (e: Exception) {
                _isLoading.value = true
                Log.d("TAG", "MovieViewModel: ${e.message}")
                moviesFromRoomDB = repository.getPopularMoviesFromDB()
                movies = moviesFromRoomDB
                popularMovies = movies.sortedByDescending { it.popularity }
                _isLoading.value = false
            }
        }
    }
}