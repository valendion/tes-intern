package com.example.androidtestintern.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidtestintern.data.WeatherRepository
import com.example.androidtestintern.di.Injection
import java.lang.IllegalArgumentException

class WeatherFactory(private val weatherRepository: WeatherRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)){
            return WeatherViewModel(weatherRepository) as T
        }
        throw IllegalArgumentException("Unknow ViewModel Class : ${modelClass.name}")
    }

    companion object{
        @Volatile
        private var instance: WeatherFactory? = null

        fun getInstance(): WeatherFactory{
            return instance ?: synchronized(this){
                instance ?: WeatherFactory(Injection.provideRepository())
            }.also { instance = it }
        }
    }
}