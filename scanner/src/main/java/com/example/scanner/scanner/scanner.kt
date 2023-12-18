@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.scanner.scanner
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState


@Composable
fun ScannerComponent(){
    val cameraPermissionState: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)

    MainScannerContent(
        hasPermission = cameraPermissionState.status.isGranted,
        onRequestPermission = cameraPermissionState::launchPermissionRequest
    )
}

@Composable
private fun MainScannerContent(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit
){
    if (hasPermission){
        CameraScan()
    }else{
        noPermissionScreen(onRequestPermission)
    }
}