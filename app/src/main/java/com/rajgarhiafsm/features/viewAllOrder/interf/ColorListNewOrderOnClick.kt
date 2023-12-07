package com.rajgarhiafsm.features.viewAllOrder.interf

import com.rajgarhiafsm.app.domain.NewOrderColorEntity
import com.rajgarhiafsm.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}