package com.rajgarhiafsm.features.viewAllOrder.interf

import com.rajgarhiafsm.app.domain.NewOrderGenderEntity
import com.rajgarhiafsm.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}