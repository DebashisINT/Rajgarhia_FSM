package com.rajgarhiafsm.features.viewAllOrder.interf

import com.rajgarhiafsm.app.domain.NewOrderGenderEntity
import com.rajgarhiafsm.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}