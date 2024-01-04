package com.example.appmovies.home.presentation

import com.example.appmovies.core.domain.model.Movie

data class HomeState (
    val upcoming: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)