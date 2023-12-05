package com.example.appmovies.core.domain.repository

import com.example.appmovies.core.domain.model.Movie

interface MovieRepository {
    suspend fun getUpcomingMovies(): List<Movie>
}