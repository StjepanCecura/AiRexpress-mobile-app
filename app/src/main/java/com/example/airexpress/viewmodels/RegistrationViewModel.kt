package com.example.airexpress.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ws.models.RegistrationBody
import com.example.ws.models.responses.RegisterdUser
import com.example.ws.network.ResponseListener
import com.example.ws.network.models.ErrorResponseBody
import com.example.ws.network.models.ResponseBody
import com.example.ws.network.models.SuccessfulResponseBody
import com.example.ws.request_handlers.RegistrationRequestHandler

class RegistrationViewModel : ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData("")
    val lastName: MutableLiveData<String> = MutableLiveData("")
    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")

    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    fun register(onSuccess: () -> Unit, onFail: () -> Unit){
        val requestBody = RegistrationBody(
            name.value!!,
            lastName.value!!,
            email.value!!,
            password.value!!
        )
        val registrationRequestHandler = RegistrationRequestHandler(requestBody)

        registrationRequestHandler.sendRequest(object: ResponseListener<RegisterdUser>{
            override fun onSuccessfulResponse(response: SuccessfulResponseBody<RegisterdUser>) {
                onSuccess()
            }

            override fun onErrorResponse(response: ResponseBody?) {
                _errorMessage.value = response?.message
                onFail()
            }

            override fun onNetworkFailure(t: Throwable) {
                _errorMessage.value = "Network error occurred, please try again later..."
                onFail()
            }
        })

    }
}