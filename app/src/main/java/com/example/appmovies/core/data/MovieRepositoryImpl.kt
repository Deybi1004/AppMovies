package com.example.appmovies.core.data

import com.example.appmovies.core.data.mapper.toDomain
import com.example.appmovies.core.data.remote.MovieApi
import com.example.appmovies.core.domain.model.Movie
import com.example.appmovies.core.domain.repository.MovieRepository

class MovieRepositoryImpl(
    val api: MovieApi
) : MovieRepository {
    override suspend fun getUpcomingMovies(): List<Movie> {
        return api.getUpcomingMovies().movieResults.map { it.toDomain() }
    }
}