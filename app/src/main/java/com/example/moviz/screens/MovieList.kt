package com.example.moviz.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.moviz.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>){

    LazyColumn {
        items(movies){
                movie -> MovieItem(movie)
        }
    }

}