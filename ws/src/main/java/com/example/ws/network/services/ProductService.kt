package com.example.ws.network.services

import com.example.ws.network.models.ScannedProductData
import com.example.ws.network.models.SuccessfulResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ProductService {

    @GET("https://ai-rexpress-mobile-web-service-git-air-a85499-mfric20s-projects.vercel.app/api/product")
    fun getProduct(@Header("Authorization") authHeader: String, @Query("variantKey") variantKey: String) : Call<SuccessfulResponseBody<ScannedProductData>>
}