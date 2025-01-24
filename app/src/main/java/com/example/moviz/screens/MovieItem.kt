package com.example.moviz.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.moviz.retrofit.Movie
import com.example.moviz.ui.theme.utils.formatDate
import com.example.moviz.ui.theme.utils.pxToDp
import com.example.moviz.ui.theme.utils.shimmerEffect

@Composable
fun MovieItem(movie: Movie) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),

        border = BorderStroke(2.dp, Color.Gray)
    ) {

        Row(modifier = Modifier.padding(8.dp)) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500/${movie.posterPath}").crossfade(true)
                    .build(), contentDescription = "Movie Image", loading = {
                    Box(
                        modifier = Modifier
                            .size(width = pxToDp(500).dp, height = pxToDp(750).dp)
                            .shimmerEffect()
                            .clip(RoundedCornerShape(16.dp))
                    )
                }, modifier = Modifier.clip(RoundedCornerShape(16.dp))

            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Release Date: ${formatDate(movie.releaseDate)}",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "User Score: ${"%.2f".format(movie.voteAverage.times(10))}/100",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
            }

        }
    }

}