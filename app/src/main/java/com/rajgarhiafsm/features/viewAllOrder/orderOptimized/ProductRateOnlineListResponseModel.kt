package com.rajgarhiafsm.features.viewAllOrder.orderOptimized

import com.rajgarhiafsm.app.domain.ProductOnlineRateTempEntity
import com.rajgarhiafsm.base.BaseResponse
import com.rajgarhiafsm.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}