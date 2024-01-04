package com.example.appmovies.core.data.remote.dto


import com.squareup.moshi.Json

data class MovieDtoResponse(
    @field:Json(name = "dates")
    val dates: Dates,
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "results")
    val movieResults: List<MovieResult>,
    @field:Json(name = "total_pages")
    val totalPages: Int,
    @field:Json(name = "total_results")
    val totalResults: Int
)