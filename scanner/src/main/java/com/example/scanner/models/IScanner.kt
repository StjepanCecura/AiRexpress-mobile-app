package com.example.scanner.models

interface IScanner {
    fun getProduct (productVariantKey : String, jwtToken : String)
}