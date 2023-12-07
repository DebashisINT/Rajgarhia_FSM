package com.rajgarhiafsm.features.nearbyuserlist.api

import com.rajgarhiafsm.app.Pref
import com.rajgarhiafsm.features.nearbyuserlist.model.NearbyUserResponseModel
import com.rajgarhiafsm.features.newcollection.model.NewCollectionListResponseModel
import com.rajgarhiafsm.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}