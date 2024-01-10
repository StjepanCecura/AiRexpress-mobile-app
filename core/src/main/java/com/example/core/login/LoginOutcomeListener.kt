package com.example.core.login

interface LoginOutcomeListener {
    fun onSuccessfulLogin(loginUserData: LoginUserData)
    fun onFailedLogin(reason: String)
}