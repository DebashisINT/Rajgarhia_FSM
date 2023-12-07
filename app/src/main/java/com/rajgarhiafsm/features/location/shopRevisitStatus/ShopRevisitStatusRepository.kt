package com.rajgarhiafsm.features.location.shopRevisitStatus

import com.rajgarhiafsm.base.BaseResponse
import com.rajgarhiafsm.features.location.model.ShopDurationRequest
import com.rajgarhiafsm.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}