package com.example.ws.network.models

class ErrorResponseBody(
    success: Boolean,
    message: String
) : ResponseBody(success, message)
