package com.example.moviz.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviz.retrofit.Movie

@Dao
interface MovieDAO {
    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM popular_movies_table")
    suspend fun getAllPopularMoviesInDB(): List<Movie>
}