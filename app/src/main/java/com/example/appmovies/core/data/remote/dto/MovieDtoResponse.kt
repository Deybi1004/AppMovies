package com.example.appmovies.core.data.remote.dto


import com.squareup.moshi.Json

data class MovieDtoResponse(
    @Json(name = "dates")
    val dates: Dates,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val movieResults: List<MovieResult>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)