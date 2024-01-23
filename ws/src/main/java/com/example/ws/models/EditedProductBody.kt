package com.example.ws.models

class EditedProductBody(
    var productID: String,
    var version: Int,
    var name: String,
    var description: String,
    var variantKey: String,
    var priceId: String,
    var amount: Float,
    var inventoryId: String,
    var inventoryVersion: Int,
    var quantity: Int,
)