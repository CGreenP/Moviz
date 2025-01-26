package com.example.moviz.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Represents a movie entity, typically fetched from a TMDB API.
 *
 * This data class is designed to be used with Room Persistence Library as an entity
 * for the "popular_movies_table". It also utilizes Gson's `@SerializedName` annotation
 * to map JSON field names to Kotlin property names.
 *
 * @property adult Indicates whether the movie is for adults only (true) or not (false).
 * @property backdropPath The URL path for the movie's backdrop image.
 * @property genreIds A list of genre IDs that the movie belongs to.
 * @property id The unique identifier for the movie. This serves as the primary key in the database.
 * @property originalLanguage The original language of the movie (e.g., "en" for English).
 * @property originalTitle The original title of the movie (in its original language).
 * @property overview A brief description or synopsis of the movie.
 * @property popularity A numerical value representing the movie's popularity.
 * @property posterPath The URL path for the movie's poster image.
 * @property releaseDate The release date of the movie in a specific format (e.g., "YYYY-MM-DD").
 * @property title The title of the movie (can be a translated title).
 * @property video Indicates whether the movie has an associated video (true) or not (false).
 * @property voteAverage The average vote rating for the movie.
 * @property voteCount The total number of votes received for the movie.
 */
@Entity(tableName = "popular_movies_table")
data class Movie(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Long>,
    @PrimaryKey
    val id: Long,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Long,
)

