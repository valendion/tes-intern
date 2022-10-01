package com.example.androidtestintern.di

import android.content.Context
import com.example.androidtestintern.data.WeatherRepository
import com.example.androidtestintern.utils.network.ApiConfig

object Injection {
    fun provideRepository(): WeatherRepository{
        val apiServiceWeather = ApiConfig.getApiService()
        return WeatherRepository.getInstance(apiServiceWeather)
    }
}