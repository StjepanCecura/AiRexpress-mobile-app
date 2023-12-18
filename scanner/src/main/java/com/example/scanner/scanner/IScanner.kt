package com.example.scanner.scanner

interface IScanner {
    fun getProduct (productVariantKey : String, jwtToken : String)
}