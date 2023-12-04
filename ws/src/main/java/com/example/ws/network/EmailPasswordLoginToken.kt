package com.example.ws.network

class EmailPasswordLoginToken(email: String, password: String) {
    private val authorizers = mapOf(
        "email" to email,
        "password" to password
    )

    fun getAuthorizers(): Map<String, String>{
        return authorizers
    }
}