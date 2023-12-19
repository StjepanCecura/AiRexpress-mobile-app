package com.example.ws.network

data class ScanProductData(
    val success: Boolean,
    val message: String,
    val productId: String,
    val name: String,
    val amount: Float,
    val currency: String,
    val quantity: Int
)
