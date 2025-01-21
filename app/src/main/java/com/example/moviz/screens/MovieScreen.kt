package com.example.moviz.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviz.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel) {
    val moviesList = viewModel.popularMovies
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        MovieList(movies = moviesList)
    }
}