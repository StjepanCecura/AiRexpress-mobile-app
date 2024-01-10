package com.example.ws.network

import com.example.ws.network.models.LoginResponseBody
import com.example.core.network.SuccessfulResponseBody

interface ResponseLoginListener <T> {
    fun onSuccessfulResponse(response: SuccessfulResponseBody<T>)
    fun onErrorResponse(response: LoginResponseBody<T>?)
    fun onNetworkFailure(t: Throwable)
}