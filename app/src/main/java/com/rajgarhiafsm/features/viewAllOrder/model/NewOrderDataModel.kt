package com.rajgarhiafsm.features.viewAllOrder.model

import com.rajgarhiafsm.app.domain.NewOrderColorEntity
import com.rajgarhiafsm.app.domain.NewOrderGenderEntity
import com.rajgarhiafsm.app.domain.NewOrderProductEntity
import com.rajgarhiafsm.app.domain.NewOrderSizeEntity
import com.rajgarhiafsm.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

