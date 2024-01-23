package com.example.core.scanner

data class ScanProductData (
    val success: Boolean,
    val productID: String?,
    val version: Int?,
    var name: String?,
    var description: String?,
    val variantKey: String?,
    val priceId: String?,
    var amount: Float?,
    val currency: String?,
    val inventoryId: String?,
    val inventoryVersion: Int?,
    var quantity: Int?
    )