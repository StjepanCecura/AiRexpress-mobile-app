package com.example.ws.request_handlers

import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.Services.NetworkService
import com.example.ws.network.models.SuccessfulResponseBody
import retrofit2.Call

class RegistrationRequestHandler(private val requestBody: RegistrationBody):
    TemplateRequestHandler<RegisterdUser>(){
    override fun getServiceCall(): Call<SuccessfulResponseBody<RegisterdUser>>{
        val service = NetworkService.authService
        return service.registerUser(requestBody)
    }
}