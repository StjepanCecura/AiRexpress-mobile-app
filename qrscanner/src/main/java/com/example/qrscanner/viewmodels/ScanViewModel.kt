package com.example.qrscanner.viewmodels

import androidx.lifecycle.ViewModel
import com.example.core.scanner.Scanner

class ScanViewModel : Scanner, ViewModel(){
    override fun getProduct(productVariantKey: String, jwtToken: String) {
        TODO("Poslati na server zahtjev za dohvaćanjem proizvoda")
    }

    override fun onSuccess() {
        TODO("Postaviti da se Product objekt postavi na vrijednost koja je dohvaćena i da se pokrene ekran za uređivanje")
    }

    override fun onFailure() {
        TODO("Prikazati Toast da proizvod sa skeniranim kodom ne postoji")
    }

}