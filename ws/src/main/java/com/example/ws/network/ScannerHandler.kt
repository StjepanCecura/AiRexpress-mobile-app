package com.example.ws.network

import android.util.Log
import com.example.core.ResponseListener
import com.example.core.network.ResponseBody
import com.example.core.network.SuccessfulResponseBody
import com.example.core.scanner.ScanOutcomeListener
import com.example.core.scanner.ScanProductData
import com.example.core.scanner.Scanner
import com.example.ws.network.models.ProductRequestBody
import com.example.ws.network.models.ScannedProductData
import com.example.ws.request_handlers.ScanRequestHandler

class ScannerHandler : Scanner{
    override fun handleScan(scanListener: ScanOutcomeListener, key: String?, jwt: String?) {
        val productRequestHandler = ScanRequestHandler(ProductRequestBody(key, jwt))

        productRequestHandler.sendRequest(
            object : ResponseListener<ScannedProductData> {
                override fun onSuccessfulResponse(response: SuccessfulResponseBody<ScannedProductData>) {
                    val responseData = response.data[0]

                    val scannedProduct = ScanProductData(
                        responseData.success,
                        responseData.productId,
                        responseData.version,
                        responseData.name,
                        responseData.description,
                        responseData.variantKey,
                        responseData.priceId,
                        responseData.amount,
                        responseData.currency,
                        responseData.inventoryId,
                        responseData.inventoryVersion,
                        responseData.quantity
                    )
                    scanListener.onSuccessfulScan(scannedProduct)
                }

                override fun onErrorResponse(response: ResponseBody) {
                    scanListener.onFailedScan("QR Code not good")
                }

                override fun onNetworkFailure(t: Throwable) {
                    scanListener.onFailedScan("Could not connect to network")

                }

            }
        )
    }

}