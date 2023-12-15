package com.example.ws.network

data class LoginUserData(
    val success: Boolean,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val jwt: String?
)