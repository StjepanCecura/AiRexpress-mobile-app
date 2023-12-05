package com.example.airexpress.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.airexpress.context.Auth
import com.example.ws.network.EmailPasswordLoginToken
import com.example.ws.network.LoginHandler
import com.example.ws.network.LoginOutcomeListener
import com.example.ws.network.LoginUserData

class LoginViewModel : ViewModel() {
    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    fun login(
        loginHandler: LoginHandler,
        onSuccessfulLogin: () -> Unit,
        onFailedLogin: () -> Unit,
        loginToken: EmailPasswordLoginToken
    ) {
        loginHandler.handleLogin(object : LoginOutcomeListener{
            override fun onSuccessfulLogin(loginUserData: LoginUserData) {
                Auth.loggedInUserData = loginUserData
                onSuccessfulLogin()
            }

            override fun onFailedLogin(reason: String) {
                _errorMessage.value = reason
                onFailedLogin()
            }
        }, loginToken
        )
    }
}