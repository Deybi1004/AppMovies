package com.example.appmovies.core.data.remote.dto


import com.squareup.moshi.Json

data class Dates(
    @field:Json(name = "maximum")
    val maximum: String,
    @field:Json(name = "minimum")
    val minimum: String
)