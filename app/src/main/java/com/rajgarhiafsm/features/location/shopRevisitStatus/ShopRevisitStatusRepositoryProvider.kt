package com.rajgarhiafsm.features.location.shopRevisitStatus

import com.rajgarhiafsm.features.location.shopdurationapi.ShopDurationApi
import com.rajgarhiafsm.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}