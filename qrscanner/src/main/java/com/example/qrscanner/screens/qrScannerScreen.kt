package com.example.qrscanner.screens

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ws.network.ScannerHandler
import com.example.core.scanner.viewmodels.ScanViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun qrScannerScreen(
    viewModelScan: ScanViewModel = viewModel(),
    onSuccessfulScan: () -> Unit,
    scanHandler: ScannerHandler
){
    Scaffold(
        modifier = Modifier.padding(10.dp)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
        ){
            val cameraPermissionState: PermissionState = rememberPermissionState(Manifest.permission.CAMERA)

            screenContent(
                hasPermission = cameraPermissionState.status.isGranted,
                onRequestPermission = cameraPermissionState::launchPermissionRequest,
                viewModelScan,
                onSuccessfulScan,
                scanHandler
            )

        }
    }
}

@Composable
private fun screenContent(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit,
    viewModelScan: ScanViewModel = viewModel(),
    onSuccessfulScan: () -> Unit,
    scanHandler: ScannerHandler
){
    if (hasPermission){
        CameraScan(viewModelScan, onSuccessfulScan, scanHandler)
    }else{
        noPermissionScreen(onRequestPermission)
    }
}