package com.example.moviz.ui.theme.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow

/**
 * A custom top app bar for the Moviz application.
 *
 * This composable displays a centered top app bar with a main title and a subtitle.
 * It also supports scrolling behavior for collapsing/expanding the app bar.
 *
 * @param scrollBehavior The scroll behavior for the top app bar. This determines how the app bar reacts to scroll events.
 *                       Use [androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior]
 *                       or [androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior]
 *                       or [androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior]
 *                       to create specific behaviors.
 * @param title The main title to be displayed in the app bar.
 * @param subtitle The subtitle to be displayed below the main title.
 *
 * @OptIn ExperimentalMaterial3Api::class is required because CenterAlignedTopAppBar and TopAppBarScrollBehavior are experimental.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovizTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior, title: String, subtitle: String
) {
    CenterAlignedTopAppBar(
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    maxLines = 1,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = subtitle,
                    maxLines = 1,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        scrollBehavior = scrollBehavior
    )
}