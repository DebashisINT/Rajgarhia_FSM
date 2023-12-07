package com.rajgarhiafsm.features.stockCompetetorStock.api

import com.rajgarhiafsm.base.BaseResponse
import com.rajgarhiafsm.features.orderList.model.NewOrderListResponseModel
import com.rajgarhiafsm.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.rajgarhiafsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}