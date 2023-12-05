package com.example.appmovies.core.data.remote

import com.example.appmovies.core.data.remote.dto.MovieDtoResponse
import retrofit2.http.GET

interface MovieApi {
    companion object{
        const val BASE_URL ="https://api.themoviedb.org/3/"
    }
    @GET("movie/upcoming") // TODO: Pagination
    suspend fun getUpcomingMovies() : MovieDtoResponse
}