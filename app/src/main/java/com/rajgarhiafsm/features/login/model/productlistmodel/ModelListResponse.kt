package com.rajgarhiafsm.features.login.model.productlistmodel

import com.rajgarhiafsm.app.domain.ModelEntity
import com.rajgarhiafsm.app.domain.ProductListEntity
import com.rajgarhiafsm.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}