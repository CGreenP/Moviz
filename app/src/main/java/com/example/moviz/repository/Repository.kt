package com.example.moviz.repository

import android.content.Context
import com.example.moviz.retrofit.Movie
import com.example.moviz.retrofit.RetrofitInstance
import com.example.moviz.room.MoviesDB

class Repository(context: Context) {

    // Fetching data from Online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    //Fetching data from Offline ROOM database
    private val db = MoviesDB.getInstance(context)
    private val moviesDAO = db.moviesDAO

    suspend fun getPopularMoviesFromDB(): List<Movie> {
        return moviesDAO.getAllPopularMoviesInDB()
    }

    suspend fun insertMoviesListToDB(movies: List<Movie>) {
        return moviesDAO.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie: Movie) {
        return moviesDAO.insert(movie)
    }

}