package com.example.ws.network.models

import com.example.core.network.ResponseBody

class LoginResponseBody<T> (success: Boolean, message: String, val data: Array<T>) : ResponseBody(success, message){
}