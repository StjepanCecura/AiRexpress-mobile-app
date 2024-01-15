package com.example.core.scanner

interface Scanner {
    fun handleScan (scanListener: ScanOutcomeListener, key: String?, jwt: String?)

}