package com.rajgarhiafsm.features.dashboard.presentation.api.dayStartEnd

import com.rajgarhiafsm.features.stockCompetetorStock.api.AddCompStockApi
import com.rajgarhiafsm.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}