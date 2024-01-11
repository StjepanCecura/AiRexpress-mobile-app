package com.example.core.scanner

data class ScanProductData (
    val success: Boolean,
    val productID: String,
    val version: Int,
    val name: String,
    val description: String,
    val variantKey: String,
    val priceId: String,
    val amount: Float,
    val currency: String,
    val quantity: Int
    )