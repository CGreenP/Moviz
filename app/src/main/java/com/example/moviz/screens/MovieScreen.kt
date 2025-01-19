package com.example.moviz.screens

import androidx.compose.runtime.Composable
import com.example.moviz.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel){
    val moviesList = viewModel.movies
    MovieList(movies = moviesList)



}