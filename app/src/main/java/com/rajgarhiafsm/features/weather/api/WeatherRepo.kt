package com.rajgarhiafsm.features.weather.api

import com.rajgarhiafsm.base.BaseResponse
import com.rajgarhiafsm.features.task.api.TaskApi
import com.rajgarhiafsm.features.task.model.AddTaskInputModel
import com.rajgarhiafsm.features.weather.model.ForeCastAPIResponse
import com.rajgarhiafsm.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}