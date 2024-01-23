package com.example.ws.models.responses

import com.google.gson.annotations.SerializedName

class EditedProduct (
    @SerializedName("productID") var productID: String? = null,
    @SerializedName("version") var productVersion: Int? = null,
    @SerializedName("product_name") var productName: String? = null,
    @SerializedName("product_description") var productDescription: String? = null,
    @SerializedName("variantKey") var productVariantKey: String? = null,
    @SerializedName("priceId") var productPriceID: String? = null,
    @SerializedName("amount") var productAmount: Float? = null,
    @SerializedName("inventoryID") var productInventoryID: String? = null,
    @SerializedName("inventoryVersion") var productInventoryVersion: Int? = null,
    @SerializedName("quantity") var productQuantity: Int? = null
)