package com.example.ws.network.services

import com.example.core.network.SuccessfulResponseBody
import com.example.core.scanner.ScanProductData
import com.example.ws.models.EditedProductBody
import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.EditedProduct
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.models.ScannedProductData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductService {
    @GET("https://ai-rexpress-mobile-web-service-git-air-a85499-mfric20s-projects.vercel.app/api/product")
    fun getProduct(@Header("Bearer") jwt: String?, @Query("variantKey") variantKey: String?) : Call<SuccessfulResponseBody<ScannedProductData>>

    @POST("https://ai-rexpress-mobile-web-service-git-air-5ee485-mfric20s-projects.vercel.app/api/product") /*https://ai-rexpress-mobile-web-service-1fafdzpc0-mfric20s-projects.vercel.app/api/users*/
    fun editProduct(@Header("Bearer") jwt: String?, @Body editProduct: EditedProductBody): Call<SuccessfulResponseBody<EditedProduct>>
}