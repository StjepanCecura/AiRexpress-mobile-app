package com.example.core

interface RequestHandler<T> {
    fun sendRequest(responseListener: ResponseListener<T>)
}