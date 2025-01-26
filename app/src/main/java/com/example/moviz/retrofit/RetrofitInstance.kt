package com.example.moviz.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * RetrofitInstance is a singleton object responsible for providing a configured instance of Retrofit
 * for making network requests to the Movie Database API.
 *
 * It uses lazy initialization to create the ApiService instance only when it's first accessed.
 * This ensures that resources are only consumed when needed.
 */
object RetrofitInstance {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val api: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}