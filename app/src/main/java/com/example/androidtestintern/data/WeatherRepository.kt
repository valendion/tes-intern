package com.example.androidtestintern.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.androidtestintern.model.ResponseWeather

import com.example.androidtestintern.utils.Status
import com.example.androidtestintern.utils.network.ApiServiceWeather
import java.lang.Exception

class WeatherRepository(private val apiServiceWeather: ApiServiceWeather) {
    fun getWeather(key: String, city: String): LiveData<Status<ResponseWeather>>{
        return liveData{
            emit(Status.Loading)

            try {
                val response = apiServiceWeather.getWeather(key, city)
                emit(Status.Success(response))
            }catch (e: Exception){
                emit(Status.Error(e.message.toString()))
            }
        }
    }

    companion object{
        @Volatile
        private var instance: WeatherRepository? =null

        fun getInstance(apiServiceWeather: ApiServiceWeather): WeatherRepository {
            return instance ?: synchronized(this){
                instance ?: WeatherRepository(apiServiceWeather)
            }.also { instance = it }
        }
    }
}