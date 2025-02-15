package com.example.moviz.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.moviz.retrofit.Movie

/**
 * Data Access Object (DAO) interface for interacting with the local movie database.
 * This interface defines methods for inserting, retrieving, and deleting movie data.
 */
@Dao
interface MovieDAO {
    @Insert
    suspend fun insert(movie: Movie)

    @Upsert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM popular_movies_table")
    suspend fun getAllPopularMoviesInDB(): List<Movie>

    @Query("DELETE FROM popular_movies_table")
    suspend fun clearAll()
}