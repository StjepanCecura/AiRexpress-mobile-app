package com.example.ws.network.services

import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.models.LoggedInUserData
import com.example.core.network.SuccessfulResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationService {
    @POST("https://air-express-mobile-web-service.vercel.app/") /*https://ai-rexpress-mobile-web-service-1fafdzpc0-mfric20s-projects.vercel.app/api/users*/
    fun registerUser(@Body registerBody: RegistrationBody): Call<SuccessfulResponseBody<RegisterdUser>>

    @GET("https://ai-rexpress-mobile-web-service-git-air-a85499-mfric20s-projects.vercel.app/api/users")
    fun loginUser(@Query("email") email: String, @Query("password") password: String) :Call<SuccessfulResponseBody<LoggedInUserData>>
}