package com.example.airexpress.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.airexpress.viewmodels.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.airexpress.ui.components.PasswordTextField
import com.example.airexpress.ui.components.StyledTextField
import com.example.airexpress.ui.theme.StyledButton
import com.example.ws.network.EmailPasswordLoginToken
import com.example.ws.network.LoginHandler

@Composable
fun LoginScreen(
    viewModelLogin: LoginViewModel = viewModel(),
    onSuccessfullLogin: () -> Unit,
    loginHandler: LoginHandler
    ){
    val email = viewModelLogin.email.observeAsState().value ?: ""
    val password = viewModelLogin.password.observeAsState().value ?: ""
    var isAwaitingResposne by remember { mutableStateOf(false) }
    val errorMessage = viewModelLogin.errorMessage.observeAsState().value ?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(vertical = 15.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        if (errorMessage.isNotBlank()){
            Text(
                text = errorMessage,
                color = Color.Red
            )
        }

        StyledTextField(
            label = "Email",
            value = email,
            onValueChange = {viewModelLogin.email.value = it}
        )

        PasswordTextField(
            label = "Password",
            value = password,
            onValueChange = {viewModelLogin.password.value = it}
        )

        Spacer(modifier = Modifier.height(50.dp))

        StyledButton(
            label = "Login",
            enabled = !isAwaitingResposne,
            onClick = {
                    isAwaitingResposne = true
                    val emailPasswordToken = EmailPasswordLoginToken(email, password)
                    viewModelLogin.login(
                        loginHandler,
                        onSuccessfulLogin = {
                            isAwaitingResposne = false
                            onSuccessfullLogin()
                        },
                        onFailedLogin = {
                            isAwaitingResposne = false
                        },
                        emailPasswordToken
                    )
            }
        )

    }
}
