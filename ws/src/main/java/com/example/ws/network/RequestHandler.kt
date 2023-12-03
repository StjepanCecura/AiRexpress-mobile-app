package com.example.ws.network

interface RequestHandler<T> {
    fun sendRequest(responseListener: ResponseListener<T>)
}