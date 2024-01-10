package com.example.core.network

class ErrorResponseBody(
    success: Boolean,
    private val errorMessage: String
) : ResponseBody(success, errorMessage)
