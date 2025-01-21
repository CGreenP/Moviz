package com.example.moviz.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviz.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>){

    LazyVerticalGrid(GridCells.Adaptive(400.dp), modifier = Modifier.fillMaxSize()) {
        items(movies, key = {it.id}){
                movie -> MovieItem(movie)
        }
    }

}