package com.example.moviz.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface defining the API service for fetching movie data.
 * This interface uses Retrofit annotations to define API endpoints and request parameters.
 */
interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String,
        @Query("page")
        page: Int
    ): MovieResponse
}