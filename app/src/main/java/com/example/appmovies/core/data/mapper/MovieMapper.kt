package com.example.appmovies.core.data.mapper

import com.example.appmovies.core.data.remote.MovieApi
import com.example.appmovies.core.data.remote.dto.MovieResult
import com.example.appmovies.core.domain.model.Movie

fun MovieResult.toDomain() : Movie {
    return Movie(
        description = this.overview,
        title = this.title,
        releaseYear = this.releaseDate.substring(0,4).toInt(),
        language = this.originalLanguage,
        rating = this.voteAverage,
        poster = MovieApi.IMAGE_URL + this.posterPath,
        genres = this.genreIds

    )
}