package com.rajgarhiafsm.features.orderList.model

import com.rajgarhiafsm.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}