@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.textrecognitionscanner

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.scanner.viewmodels.ScanViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.example.ws.network.ScannerHandler
import com.google.accompanist.permissions.rememberPermissionState
import androidx.compose.material3.Button

@Composable
fun textRecognitionScannerButton(
    onTextButtonClick: () -> Unit
){
    Button(
        onClick = onTextButtonClick,
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .defaultMinSize(minWidth = 80.dp)
            .height(50.dp)
    ){
        Text(
            text = "Scan text",
            color = Color.White
        )
    }
}


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