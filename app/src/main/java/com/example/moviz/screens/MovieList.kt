package com.example.moviz.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviz.retrofit.Movie

/**
 * Displays a grid of movie items.
 *
 * This composable function takes a list of [Movie] objects and displays them in a
 * responsive grid layout using [LazyVerticalGrid]. Each movie in the list is rendered
 * using the [MovieItem] composable. The grid dynamically adjusts the number of columns
 * based on the available screen width, with a minimum item width of 400dp.
 *
 * @param movies The list of [Movie] objects to be displayed in the grid.
 *               Each movie will be rendered as a separate item.
 *
 * @see LazyVerticalGrid
 * @see GridCells.Adaptive
 * @see MovieItem
 * @see Movie
 */
@Composable
fun MovieList(movies: List<Movie>) {

    LazyVerticalGrid(GridCells.Adaptive(400.dp), modifier = Modifier.fillMaxSize()) {
        items(movies, key = { it.id }) { movie ->
            MovieItem(movie)
        }
    }

}