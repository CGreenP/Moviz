package com.example.moviz.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviz.viewmodel.MovieViewModel

/**
 * Displays the main screen for showing a list of movies.
 *
 * This composable fetches and displays a list of popular movies from the provided [MovieViewModel].
 * It handles different states of the data fetching process, including loading, success, and error.
 *
 * @param viewModel The [MovieViewModel] instance that provides the movie data and state.
 *
 * State Handling:
 * - **Loading:** When `isLoading` is true, a [CircularProgressIndicator] is displayed in the center of the screen.
 * - **Success:** When `isLoading` is false and `moviesList` is not empty, the [MovieList] composable is used to display the list of movies.
 * - **Error:** When `isLoading` is false, `moviesList` is empty, and `error` is true, an error message with a warning icon is displayed.
 *
 * UI Components:
 * - [CircularProgressIndicator]: Shown during the loading state.
 * - [MovieList]: Displays the list of movies when data is successfully fetched.
 * - [Icon] (Warning): Displays a warning icon when an error occurs.
 * - [Text]: Displays error messages or titles.
 *
 * Data:
 * - `moviesList`: A list of movies fetched from the [MovieViewModel].
 * - `isLoading`: A boolean indicating whether data is currently being loaded.
 * - `error`: A boolean indicating whether an error occurred during data fetching.
 *
 * Example Usage:
 * ```kotlin
 * MovieScreen(movieViewModel)
 * ```
 */
@Composable
fun MovieScreen(viewModel: MovieViewModel) {
    val moviesList = viewModel.popularMovies
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        if (moviesList.isEmpty() && error && !isLoading ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Warning",
                        modifier = Modifier.size(120.dp),
                        tint = MaterialTheme.colorScheme.error
                    )
                    Text(
                        text = "Failed to load data",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        } else {
            MovieList(movies = moviesList)
        }
    }
}