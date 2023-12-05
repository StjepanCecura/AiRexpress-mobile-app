package com.example.ws.network

import android.util.Log
import com.example.ws.network.models.LoggedInUserData
import com.example.ws.network.models.LoginBody
import com.example.ws.network.models.LoginResponseBody
import com.example.ws.network.models.ResponseBody
import com.example.ws.network.models.SuccessfulResponseBody
import com.example.ws.request_handlers.LoginRequestHandler

class EmailPasswordLoginHandler : LoginHandler {
    override fun handleLogin(
        loginListener: LoginOutcomeListener,
        logintoken: EmailPasswordLoginToken
        ) {

        val authorizers = logintoken.getAuthorizers()
        val email = authorizers["email"]!!
        val password = authorizers["password"]!!

        val loginRequestHandler = LoginRequestHandler(LoginBody(email, password))

        loginRequestHandler.sendRequest(
            object : ResponseListener<LoggedInUserData>{

                override fun onSuccessfulResponse(response: SuccessfulResponseBody<LoggedInUserData>) {

                    val loggedInUser = LoginUserData(true, "", "", email)
                    loginListener.onSuccessfulLogin(loggedInUser)

                }

                override fun onErrorResponse(response: ResponseBody?) {
                    if (response == null) {
                        loginListener.onFailedLogin("Something went wrong")
                    }else{
                        loginListener.onFailedLogin("Message: "+response.message)
                    }

                }

                override fun onNetworkFailure(t: Throwable) {
                    loginListener.onFailedLogin("Could not connect to network")
                }

            }
        )
    }

}