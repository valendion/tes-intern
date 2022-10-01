package com.example.androidtestintern.ui

import androidx.lifecycle.ViewModel
import com.example.androidtestintern.data.WeatherRepository

class WeatherViewModel(private val weatherRepository: WeatherRepository): ViewModel() {
    fun getWeather(key: String, city: String) = weatherRepository.getWeather(key, city)
}