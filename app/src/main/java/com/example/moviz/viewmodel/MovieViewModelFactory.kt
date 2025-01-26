package com.example.moviz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviz.repository.Repository

/**
 * Factory for creating [MovieViewModel] instances.
 *
 * This factory is responsible for instantiating the [MovieViewModel]
 * and providing it with the necessary [Repository] dependency.
 * It ensures that the [MovieViewModel] is created with the correct
 * dependencies, promoting dependency injection and testability.
 *
 * @param repository The [Repository] instance to be injected into the [MovieViewModel].
 *                   This repository is responsible for data access.
 */
class MovieViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}