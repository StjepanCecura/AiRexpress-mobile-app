package com.example.core.network

class SuccessfulResponseBody<T>(success: Boolean, message: String, val data: Array<T>) : ResponseBody(success, message)