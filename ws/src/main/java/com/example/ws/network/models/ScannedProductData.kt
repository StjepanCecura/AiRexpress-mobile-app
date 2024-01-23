package com.example.ws.network.models

import com.google.gson.annotations.SerializedName

class ScannedProductData (
    @SerializedName("success") var success: Boolean = true,
    @SerializedName("productId") var productId: String? = null,
    @SerializedName("version") var version: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("variantKey") var variantKey: String? = null,
    @SerializedName("priceId") var priceId: String? = null,
    @SerializedName("amount") var amount: Float? = null,
    @SerializedName("currency") var currency: String? = null,
    @SerializedName("inventoryId") var inventoryId: String? = null,
    @SerializedName("inventoryVersion") var inventoryVersion: Int? = null,
    @SerializedName("quantity") var quantity: Int? = null,
)