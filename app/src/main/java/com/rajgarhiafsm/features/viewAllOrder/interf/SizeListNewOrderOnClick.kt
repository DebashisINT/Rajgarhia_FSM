package com.rajgarhiafsm.features.viewAllOrder.interf

import com.rajgarhiafsm.app.domain.NewOrderProductEntity
import com.rajgarhiafsm.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}