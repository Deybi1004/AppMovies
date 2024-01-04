package com.example.appmovies.core.data

import android.util.Log
import com.example.appmovies.core.data.mapper.toDomain
import com.example.appmovies.core.data.remote.MovieApi
import com.example.appmovies.core.domain.model.Movie
import com.example.appmovies.core.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {
    override suspend fun getUpcomingMovies(): Result<List<Movie>> {

        return try {
            val results = api.getUpcomingMovies().movieResults
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return try {
            val results = api.getPopularMovies().movieResults
            Result.success(results.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}