package com.example.core.scanner

interface ScanOutcomeListener {

    fun onSuccessfulScan (scanProduct: ScanProductData)
    fun onFailedScan (reason: String)
}