@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.textrecognitionscanner

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.scanner.viewmodels.ScanViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.example.ws.network.ScannerHandler
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun textRecognitionScanner(
    viewModelScan: ScanViewModel = viewModel(),
    onSuccessfulScan: () -> Unit,
    scanHandler: ScannerHandler
) {

    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    MainContent(
        hasPermission = cameraPermissionState.status.isGranted,
        onRequestPermission = cameraPermissionState::launchPermissionRequest,
        viewModelScan,
        onSuccessfulScan,
        scanHandler
    )
}

@Composable
private fun MainContent(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit,
    viewModelScan: ScanViewModel,
    onSuccessfulScan: () -> Unit,
    scanHandler: ScannerHandler
){
    if (hasPermission){
        CameraScreen(viewModelScan, onSuccessfulScan, scanHandler)
    } else{
        noPermissionScreen(onRequestPermission)
    }
}