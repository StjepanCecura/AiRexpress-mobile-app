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
import com.example.core.login.LoginUserData
import com.example.qrscanner.context.Auth
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun qrScannerScreen(user : LoginUserData?){
    Auth.loggedInUser = user
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
                onRequestPermission = cameraPermissionState::launchPermissionRequest
            )

        }
    }
}

@Composable
private fun screenContent(
    hasPermission: Boolean,
    onRequestPermission: () -> Unit
){
    if (hasPermission){
        CameraScan()
    }else{
        noPermissionScreen(onRequestPermission)
    }
}