package com.example.ws.request_handlers

import android.util.Log
import com.google.gson.Gson
import com.example.ws.network.RequestHandler
import com.example.ws.network.ResponseListener
import com.example.ws.network.models.ErrorResponseBody
import com.example.ws.network.models.SuccessfulResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class TemplateRequestHandler<T>  : RequestHandler<T> {
    override fun sendRequest(responseListener: ResponseListener<T>) {
        val serviceCall = getServiceCall()

        serviceCall.enqueue(object : Callback<SuccessfulResponseBody<T>> {
            override fun onResponse(
                call: Call<SuccessfulResponseBody<T>>,
                response: Response<SuccessfulResponseBody<T>>
            ) {
                if (response.isSuccessful) {
                    if (response.body().success){
                        Log.i("response.body", "" + response.body())
                        responseListener.onSuccessfulResponse(response.body())
                    }else{
                        val errorBodyString = response.errorBody()?.string()

                        val errorResponse = if (!errorBodyString.isNullOrBlank()) {
                            Gson().fromJson(errorBodyString, ErrorResponseBody::class.java)
                        } else {
                            ErrorResponseBody(false, "Something went wrong -> no response body from server")
                        }
                        responseListener.onErrorResponse(errorResponse)

                    }
                } else {
                    val errorBodyString = response.errorBody()?.string()
                    val errorResponse = if (!errorBodyString.isNullOrBlank()) {
                        Gson().fromJson(errorBodyString, ErrorResponseBody::class.java)
                    } else {
                        ErrorResponseBody(false,"No answer from server")
                    }
                    responseListener.onErrorResponse(errorResponse)
                }
            }

            override fun onFailure(call: Call<SuccessfulResponseBody<T>>, t: Throwable) {
                responseListener.onNetworkFailure(t)
            }
        })
    }

    protected abstract fun getServiceCall(): Call<SuccessfulResponseBody<T>>
}