package com.rajgarhiafsm.features.location.api

import com.rajgarhiafsm.features.location.shopdurationapi.ShopDurationApi
import com.rajgarhiafsm.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}