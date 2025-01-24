package com.example.moviz.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
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

        border = BorderStroke(
            2.dp, brush = Brush.horizontalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.surfaceContainerLowest,
                    MaterialTheme.colorScheme.surfaceContainerHighest
                ),
                startX = 0f,
                endX = 1000f,
                tileMode = TileMode.Mirror,
            )
        )
    ) {

        var showMoreButton by remember { mutableStateOf(true) }
        var showLessButton by remember { mutableStateOf(false) }
        var hasVisualOverflow by remember { mutableStateOf(false) }

        val infiniteTransition = rememberInfiniteTransition(label = "background")
        val targetOffset = with(LocalDensity.current) {
            1000.dp.toPx()
        }
        val offset by infiniteTransition.animateFloat(
            initialValue = 0f, targetValue = targetOffset, animationSpec = infiniteRepeatable(
                tween(20000, easing = LinearEasing), repeatMode = RepeatMode.Reverse
            ), label = "offset"
        )
        val brushColors = listOf(
            MaterialTheme.colorScheme.surfaceContainerHighest,
            MaterialTheme.colorScheme.surfaceContainerLowest
        )

        Row(modifier = Modifier
            .drawWithCache {
                val brushSize = 400f
                val brush = Brush.linearGradient(
                    colors = brushColors,
                    start = Offset(offset, offset),
                    end = Offset(offset + brushSize, offset + brushSize),
                    tileMode = TileMode.Mirror
                )
                onDrawBehind {
                    drawRect(brush)
                }
            }) {

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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.DateRange, contentDescription = "Release Date Icon"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = formatDate(movie.releaseDate),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Default.FavoriteBorder, contentDescription = "Release Date Icon"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "User Score: ${"%.2f".format(movie.voteAverage.times(10))}/100",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = movie.overview,
                    maxLines = if (showMoreButton) 7 else Int.MAX_VALUE,
                    overflow = TextOverflow.Ellipsis,
                    onTextLayout = {
                        if (it.hasVisualOverflow) {
                            hasVisualOverflow = true
                            showMoreButton = true
                        }
                    },
                    style = MaterialTheme.typography.bodySmall
                )
                if (showMoreButton && hasVisualOverflow) {
                    Text(text = "Show More",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            showMoreButton = false
                            showLessButton = true
                        })
                }
                if (hasVisualOverflow && showLessButton) {
                    Text(text = "Show Less",
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            showMoreButton = true
                            showLessButton = false
                        })
                }

            }
        }
    }
}