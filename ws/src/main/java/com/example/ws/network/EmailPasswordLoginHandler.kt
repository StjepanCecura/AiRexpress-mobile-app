package com.example.ws.network

import com.example.core.login.EmailPasswordLoginToken
import com.example.core.login.LoginHandler
import com.example.core.login.LoginOutcomeListener
import com.example.core.login.LoginUserData
import com.example.ws.network.models.LoggedInUserData
import com.example.ws.network.models.LoginBody
import com.example.core.network.ResponseBody
import com.example.core.ResponseListener
import com.example.core.network.SuccessfulResponseBody
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
            object : ResponseListener<LoggedInUserData> {

                override fun onSuccessfulResponse(response: SuccessfulResponseBody<LoggedInUserData>) {

                    val responseData = response.data[0]

                    val loggedInUser = LoginUserData(responseData.success, responseData.firstName, responseData.lastName, responseData.email, responseData.jwt)
                    loginListener.onSuccessfulLogin(loggedInUser)

                }

                override fun onErrorResponse(response: ResponseBody?) {
                    loginListener.onFailedLogin("Please enter valid credentials!")
                }

                override fun onNetworkFailure(t: Throwable) {
                    loginListener.onFailedLogin("Could not connect to network")
                }

            }
        )
    }

}