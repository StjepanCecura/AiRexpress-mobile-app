package com.example.ws.network

import com.example.ws.network.models.ErrorResponseBody
import com.example.ws.network.models.SuccessfulResponseBody

interface ResponseListener<T> {
    fun onSuccessfulResponse(response: SuccessfulResponseBody<T>)
    fun onErrorResponse(response: ErrorResponseBody)
    fun onNetworkFailure(t: Throwable)
}