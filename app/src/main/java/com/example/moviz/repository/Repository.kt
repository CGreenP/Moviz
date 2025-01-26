package com.example.moviz.repository

import android.content.Context
import com.example.moviz.retrofit.Movie
import com.example.moviz.retrofit.RetrofitInstance
import com.example.moviz.room.MoviesDB

/**
 * Repository class responsible for managing data from both online (API) and offline (Room Database) sources.
 *
 * This class acts as a single source of truth for movie data, abstracting the data access logic
 * from the rest of the application. It handles fetching movie lists from the online API and
 * managing movie data within the Room database.
 *
 * @property context The application context, used for database initialization.
 */
class Repository(context: Context) {

    // Fetching data from Online API
    suspend fun getPopularMoviesFromOnlineApi(apiKey: String, page: Int): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey, page).results
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