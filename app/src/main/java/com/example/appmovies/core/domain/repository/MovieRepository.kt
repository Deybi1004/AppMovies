package com.example.appmovies.core.domain.repository

import com.example.appmovies.core.domain.model.Movie

interface MovieRepository {
    suspend fun getUpcomingMovies(): Result<List<Movie>>
    suspend fun getPopularMovies(): Result<List<Movie>>
}