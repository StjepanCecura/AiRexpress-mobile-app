package com.example.ws.network

interface LoginHandler {

    fun handleLogin(loginListener: LoginOutcomeListener, loginToken: EmailPasswordLoginToken)

}