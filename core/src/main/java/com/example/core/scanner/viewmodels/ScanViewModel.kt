package com.example.core.scanner.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.context.Product
import com.example.core.scanner.ScanOutcomeListener
import com.example.core.scanner.ScanProductData
import com.example.core.scanner.Scanner

class ScanViewModel() : ViewModel(){
    var key: String? = null
    var jwt: String? = null

    fun scan(
        scanner: Scanner,
        onSuccessfulScan: () -> Unit,
        onFailedScan: () -> Unit
    ){
        scanner.handleScan(object : ScanOutcomeListener{
            override fun onSuccessfulScan(scanProduct: ScanProductData) {
                Product.scannedProduct = scanProduct
                onSuccessfulScan()
            }

            override fun onFailedScan(reason: String) {
                onFailedScan()
            }

        },
            key,
            jwt
        )
    }
}