package com.example.core.login

interface LoginHandler {

    fun handleLogin(loginListener: LoginOutcomeListener, loginToken: EmailPasswordLoginToken)

}