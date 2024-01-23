package com.example.airexpress.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.ResponseListener
import com.example.core.context.Auth
import com.example.core.network.ResponseBody
import com.example.core.network.SuccessfulResponseBody
import com.example.ws.models.EditedProductBody
import com.example.ws.models.responses.EditedProduct
import com.example.ws.request_handlers.EditRequestHandler

class EditViewModel : ViewModel() {
    val productID: MutableLiveData<String> = MutableLiveData("")
    val productVersion: MutableLiveData<Int> = MutableLiveData()
    val productName: MutableLiveData<String> = MutableLiveData("")
    val productDescription: MutableLiveData<String> = MutableLiveData("")
    val productVariantKey: MutableLiveData<String> = MutableLiveData("")
    val productPriceID: MutableLiveData<String> = MutableLiveData("")
    val productAmount: MutableLiveData<String> = MutableLiveData("")
    val productInventoryID: MutableLiveData<String> = MutableLiveData("")
    val productInventoryVersion: MutableLiveData<String> = MutableLiveData("")
    val productQuantity: MutableLiveData<String> = MutableLiveData("")

    private val _errorMessage: MutableLiveData<String> = MutableLiveData("")
    val errorMessage: LiveData<String> = _errorMessage

    fun edit(onSuccess: () -> Unit, onFail: () -> Unit){
        val requestBody = EditedProductBody(
            productID.value!!,
            productVersion.value!!,
            productName.value!!,
            productDescription.value!!,
            productVariantKey.value!!,
            productPriceID.value!!,
            productAmount.value!!.toFloat(),
            productInventoryID.value!!,
            productInventoryVersion.value!!.toInt(),
            productQuantity.value!!.toInt()
        )
        val editRequestHandler = EditRequestHandler(requestBody)

        editRequestHandler.sendRequest(object: ResponseListener<EditedProduct> {
            override fun onSuccessfulResponse(response: SuccessfulResponseBody<EditedProduct>) {
                onSuccess()
            }

            override fun onErrorResponse(response: ResponseBody) {
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