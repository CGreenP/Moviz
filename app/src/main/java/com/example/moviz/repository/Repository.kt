package com.example.moviz.repository

import com.example.moviz.retrofit.Movie
import com.example.moviz.retrofit.RetrofitInstance

class Repository {

    // Fetching data from Online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}