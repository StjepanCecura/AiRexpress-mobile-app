package com.example.ws.network.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "https://ai-rexpress-mobile-web-service-gylkx48qa-mfric20s-projects.vercel.app/api/users/"

    private var instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val authService: AuthenticationService = instance.create(AuthenticationService::class.java)
}