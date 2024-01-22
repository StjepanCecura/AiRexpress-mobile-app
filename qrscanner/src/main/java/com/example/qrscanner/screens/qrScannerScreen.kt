package com.example.qrscanner.screens

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ws.network.ScannerHandler
import com.example.core.scanner.viewmodels.ScanViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun qrScannerScreenButton(
    onQrCodeButtonClick: () -> Unit
){
    Button(
        onClick = onQrCodeButtonClick,
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .defaultMinSize(minWidth = 80.dp)
            .height(50.dp)
    ) {
        Text(
            text = "Scan QR code",
            color = Color.White,
        )
    }
}

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