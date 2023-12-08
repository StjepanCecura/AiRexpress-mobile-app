package com.example.airexpress.screens.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.airexpress.viewmodels.RegistrationViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.airexpress.ui.components.PasswordTextField
import com.example.airexpress.ui.components.StyledTextField
import com.example.airexpress.ui.theme.StyledButton

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = viewModel(),
    onSuccessfulRegistration: (newEmail: String) -> Unit
) {
    val name = viewModel.name.observeAsState().value ?: ""
    val lastName = viewModel.lastName.observeAsState().value ?: ""
    val email = viewModel.email.observeAsState().value ?: ""
    val password = viewModel.password.observeAsState().value ?: ""

    val errorMessage = viewModel.errorMessage.observeAsState().value ?: ""

    var isAwaitingResponse by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(vertical = 15.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text(
            text = "Register here.",
            style = MaterialTheme.typography.h4
        )

        if (errorMessage.isNotBlank()){
            Text(
                text = errorMessage,
                color = Color.Red
            )
        }

        StyledTextField(
            label = "Name",
            value = name,
            onValueChange = {viewModel.name.value = it}
        )

        StyledTextField(
            label = "Last name",
            value = lastName,
            onValueChange = {viewModel.lastName.value = it}
        )

        StyledTextField(
            label = "Email",
            value = email,
            onValueChange = {viewModel.email.value = it}
        )

        PasswordTextField(
            label = "Password",
            value = password,
            onValueChange = {viewModel.password.value = it}
        )

        Spacer(modifier = Modifier.height(50.dp))

        StyledButton(
            label = "Register",
            enabled = !isAwaitingResponse,
            onClick = {
                isAwaitingResponse = true
                viewModel.register(
                    onSuccess = {
                        isAwaitingResponse = false
                        onSuccessfulRegistration(email)
                    },
                    onFail = {
                        isAwaitingResponse = false
                    }
                )
            }
        )



    }
}