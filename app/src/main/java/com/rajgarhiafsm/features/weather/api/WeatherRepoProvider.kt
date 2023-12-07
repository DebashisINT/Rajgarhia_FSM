package com.rajgarhiafsm.features.weather.api

import com.rajgarhiafsm.features.task.api.TaskApi
import com.rajgarhiafsm.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}