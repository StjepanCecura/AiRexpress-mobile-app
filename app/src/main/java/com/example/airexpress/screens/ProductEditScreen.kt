package com.example.airexpress.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.airexpress.ui.components.StyledTextField
import com.example.airexpress.ui.theme.StyledButton
import com.example.airexpress.viewmodels.EditViewModel
import com.example.core.context.Product

@Composable
fun ProductEdit(
    viewModel: EditViewModel = viewModel(),
    onSuccessfulEdit: (newEdit: String) -> Unit
){

    //val name = viewModel.name.observeAsState().value ?: ""

    var productName = Product.scannedProduct.name

    viewModel.productID.value = Product.scannedProduct.productID
    viewModel.productVersion.value = Product.scannedProduct.version
    val productNameEdit = viewModel.productName.observeAsState().value ?: ""
    var productDescription = viewModel.productDescription.observeAsState().value ?: ""
    viewModel.productVariantKey.value = Product.scannedProduct.variantKey
    viewModel.productPriceID.value = Product.scannedProduct.priceId
    var productAmount = viewModel.productAmount.observeAsState().value ?: ""
    viewModel.productInventoryID.value = Product.scannedProduct.inventoryId
    viewModel.productInventoryVersion.value = Product.scannedProduct.inventoryVersion.toString()
    var productQuantity = viewModel.productQuantity.observeAsState().value ?: ""

    var isAwaitingResponse by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        if (productNameEdit != null) {
            StyledTextField(
                value = productNameEdit,
                label = "Naziv proizvoda",
                onValueChange = { viewModel.productName.value = it },
            )
        }

        if (productDescription != null) {
            StyledTextField(
                value = productDescription,
                label = "Opis proizvoda",
                onValueChange = { viewModel.productDescription.value = it },
            )
        }
        if (productQuantity != null) {
            StyledTextField(
                value = productQuantity,
                label = "Product quantity",
                onValueChange = { viewModel.productQuantity.value = it }
            )
        }
        if (productAmount != null) {
            StyledTextField(
                value = productAmount,
                label = "Product amount",
                onValueChange = { viewModel.productAmount.value = it }
            )
        }
        StyledButton(
            label = "Update product",
            enabled = !isAwaitingResponse,
            onClick = {
                isAwaitingResponse = true
                viewModel.edit(
                    onSuccess = {
                        isAwaitingResponse = false
                        productName?.let { onSuccessfulEdit(it) }
                    },
                    onFail = {
                        isAwaitingResponse = false
                    }
                )
            }
        )
    }
}