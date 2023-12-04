package com.example.ws.network.services

import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.models.SuccessfulResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("https://ai-rexpress-mobile-web-service-gylkx48qa-mfric20s-projects.vercel.app/api/users")
    fun registerUser(@Body registerBody: RegistrationBody): Call<SuccessfulResponseBody<RegisterdUser>>
}