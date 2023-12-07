package com.rajgarhiafsm.features.stockAddCurrentStock.api

import com.rajgarhiafsm.base.BaseResponse
import com.rajgarhiafsm.features.location.model.ShopRevisitStatusRequest
import com.rajgarhiafsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.rajgarhiafsm.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.rajgarhiafsm.features.stockAddCurrentStock.model.CurrentStockGetData
import com.rajgarhiafsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}