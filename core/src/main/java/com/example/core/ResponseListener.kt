package com.example.core

import com.example.core.network.ResponseBody
import com.example.core.network.SuccessfulResponseBody

interface ResponseListener<T> {
    fun onSuccessfulResponse(response: SuccessfulResponseBody<T>)
    fun onErrorResponse(response: ResponseBody)
    fun onNetworkFailure(t: Throwable)
}