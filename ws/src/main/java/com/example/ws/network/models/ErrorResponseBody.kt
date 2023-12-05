package com.example.ws.network.models

class ErrorResponseBody(
    success: Boolean,
    private val errorMessage: String
) : ResponseBody(success, errorMessage)
