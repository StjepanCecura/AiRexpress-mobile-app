package com.example.ws.request_handlers

import com.example.ws.network.models.LoggedInUserData
import com.example.ws.network.models.LoginBody
import com.example.core.network.SuccessfulResponseBody
import com.example.ws.network.services.NetworkService
import retrofit2.Call

class LoginRequestHandler(private val requestBody: LoginBody) : TemplateRequestHandler<LoggedInUserData>() {
    override fun getServiceCall(): Call<SuccessfulResponseBody<LoggedInUserData>> {
        val service = NetworkService.authService
        return service.loginUser(requestBody.email, requestBody.password)
    }

}