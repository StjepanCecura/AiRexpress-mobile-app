package com.example.ws.request_handlers

import com.example.core.context.Auth
import com.example.core.network.SuccessfulResponseBody
import com.example.ws.models.EditedProductBody
import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.EditedProduct
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.services.NetworkService
import com.example.ws.network.services.ProductService
import retrofit2.Call

class EditRequestHandler(private val requestBody: EditedProductBody):
    TemplateRequestHandler<EditedProduct>(){
    override fun getServiceCall(): Call<SuccessfulResponseBody<EditedProduct>> {
        val service = NetworkService.productService
        val jwt = Auth.loggedInUser?.jwt
        return service.editProduct(jwt, requestBody)
    }
}