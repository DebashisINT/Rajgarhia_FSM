package com.rajgarhiafsm.features.viewAllOrder.interf

import com.rajgarhiafsm.app.domain.NewOrderGenderEntity
import com.rajgarhiafsm.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}