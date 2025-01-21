package com.example.moviz.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviz.repository.Repository
import com.example.moviz.retrofit.Movie
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.moviz.BuildConfig
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository): ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromAPI by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set


    init {
        viewModelScope.launch{
            try {

                val apiKey = BuildConfig.API_KEY
                moviesFromAPI=repository.getPopularMoviesFromOnlineApi(apiKey)

                repository.insertMoviesListToDB(moviesFromAPI)

                movies=moviesFromAPI
            }catch (e:Exception){
                moviesFromRoomDB=repository.getPopularMoviesFromDB()
                movies=moviesFromRoomDB
            }
        }
    }
}