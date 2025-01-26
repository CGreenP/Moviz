package com.example.moviz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.ViewModelProvider
import com.example.moviz.repository.Repository
import com.example.moviz.screens.MovieScreen
import com.example.moviz.ui.theme.MovizTheme
import com.example.moviz.ui.theme.utils.MovizTopAppBar
import com.example.moviz.viewmodel.MovieViewModel
import com.example.moviz.viewmodel.MovieViewModelFactory


/**
 * The main activity of the Moviz application.
 *
 * This activity is the entry point of the app and is responsible for:
 * - Setting up the UI using Jetpack Compose.
 * - Enabling edge-to-edge display.
 * - Creating and providing the [MovieViewModel] to the UI.
 * - Setting up the main UI layout with a [Scaffold] and a [MovizTopAppBar].
 * - Displaying the [MovieScreen] to show the list of movies.
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository(applicationContext)

        val viewModelFactory = MovieViewModelFactory(repository)

        val movieViewModel = ViewModelProvider(
            this, viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            MovizTheme {
                val scrollBehavior =
                    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        MovizTopAppBar(
                            scrollBehavior = scrollBehavior,
                            title = "Moviz",
                            subtitle = "Top 20 Popular Movies Right Now"
                        )
                    }) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        MovieScreen(viewModel = movieViewModel)
                    }
                }
            }
        }
    }
}