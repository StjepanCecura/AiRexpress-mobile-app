package com.example.core.scanner

interface Scanner {
    fun getProduct (productVariantKey : String, jwtToken : String)
    fun onSuccess ()
    fun onFailure ()
}