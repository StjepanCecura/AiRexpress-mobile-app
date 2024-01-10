package com.example.ws.network.models

class SuccessfulResponseBody<T>(success: Boolean, message: String, val data: Array<T>) : ResponseBody(success, message)