package com.example.ws.network.Services

import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.models.SuccessfulResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("auth/register")
    fun registerUser(@Body registerBody: RegistrationBody): Call<SuccessfulResponseBody<RegisterdUser>>
}