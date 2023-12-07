package com.rajgarhiafsm.features.newcollectionreport

import com.rajgarhiafsm.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}