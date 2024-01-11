package com.example.airexpress.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.context.Auth
import com.example.core.login.EmailPasswordLoginToken
import com.example.core.login.LoginHandler
import com.example.core.login.LoginOutcomeListener
import com.example.core.login.LoginUserData

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
        loginHandler.handleLogin(object : LoginOutcomeListener {
            override fun onSuccessfulLogin(loginUserData: LoginUserData) {
                Auth.loggedInUser = loginUserData
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