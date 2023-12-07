package com.rajgarhiafsm.features.photoReg.present

import com.rajgarhiafsm.app.domain.ProspectEntity
import com.rajgarhiafsm.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}