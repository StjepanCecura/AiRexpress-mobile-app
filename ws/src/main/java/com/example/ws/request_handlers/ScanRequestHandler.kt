package com.example.ws.request_handlers

import com.example.core.network.SuccessfulResponseBody
import com.example.core.scanner.ScanProductData
import com.example.ws.network.models.ProductRequestBody
import com.example.ws.network.models.ScannedProductData
import com.example.ws.network.services.NetworkService
import retrofit2.Call

class ScanRequestHandler(private val requestBody: ProductRequestBody) : TemplateRequestHandler<ScannedProductData>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<ScannedProductData>> {
        val service = NetworkService.productService
        return service.getProduct(requestBody.jwt, requestBody.key)
    }
}