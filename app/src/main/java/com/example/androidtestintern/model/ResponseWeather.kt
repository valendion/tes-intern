package com.example.androidtestintern.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseWeather(
    @Json(name = "current")
    var current: Current
)

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "temp_c")
    var tempC: Double,

    @Json(name = "temp_f")
    var tempF: Double
)