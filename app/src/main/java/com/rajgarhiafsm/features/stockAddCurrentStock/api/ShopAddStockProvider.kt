package com.rajgarhiafsm.features.stockAddCurrentStock.api

import com.rajgarhiafsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.rajgarhiafsm.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}