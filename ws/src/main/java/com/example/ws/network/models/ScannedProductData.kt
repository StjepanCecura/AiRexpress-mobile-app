package com.example.ws.network.models
import com.google.gson.annotations.SerializedName

class ScannedProductData (
    @SerializedName("success") var success: Boolean = true,
    @SerializedName("message") var message: String? = null,
    @SerializedName("productId") var productId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("amount") var amount: Float? = null,
    @SerializedName("currency") var currency: String? = null,
    @SerializedName("quantity") var quantity: Int? = null
)