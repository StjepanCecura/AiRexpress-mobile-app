package com.example.qrscanner

import android.content.Context
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import kotlinx.coroutines.flow.MutableStateFlow

class Scanner(
    context: Context
) {
    private val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_ALL_FORMATS
        )
        .build()

    private val scanner = GmsBarcodeScanning.getClient(context, options)
    val codeResult = MutableStateFlow<String?>(null)

    fun startScan(){
        try{
            scanner.startScan()
                .addOnSuccessListener {
                    code ->
                        codeResult.value = code.displayValue
                }
                .addOnCanceledListener {
                    codeResult.value = "canceled"
                }
                .addOnFailureListener{
                    e ->
                        codeResult.value = "failed: "+ e.message
                }
        }catch (e: Exception){
            codeResult.value = "Not able to start "
        }
    }
}