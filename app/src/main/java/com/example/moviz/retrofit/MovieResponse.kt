package com.example.moviz.retrofit

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val page: Long,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)