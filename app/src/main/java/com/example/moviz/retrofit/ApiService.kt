package com.example.moviz.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey: String,
//        @Query("page")
//        page: Int
    ): MovieResponse
}