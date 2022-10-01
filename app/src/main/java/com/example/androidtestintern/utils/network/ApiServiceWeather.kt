package com.example.androidtestintern.utils.network

import com.example.androidtestintern.model.ResponseWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceWeather {
    @GET("current.json")
    suspend fun getWeather(@Query("key") key: String, @Query("q") city: String): ResponseWeather
}