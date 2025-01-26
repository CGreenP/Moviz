package com.example.moviz.retrofit

import com.google.gson.annotations.SerializedName

/**
 * Represents a response containing a paginated list of movies.
 *
 * This data class models the structure of a typical API response for a list of movies,
 * including pagination information. It's designed to be used with a JSON parsing library like Gson
 * to map the response from an API directly to this class.
 *
 * @property page The current page number of the results.
 * @property results A list of [Movie] objects representing the movies on the current page.
 * @property totalPages The total number of pages available for this query.
 * @property totalResults The total number of movies available for this query across all pages.
 */
data class MovieResponse(
    val page: Long,
    val results: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Long,
    @SerializedName("total_results")
    val totalResults: Long,
)