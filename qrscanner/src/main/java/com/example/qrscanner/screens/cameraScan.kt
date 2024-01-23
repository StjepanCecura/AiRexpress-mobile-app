package com.example.qrscanner.screens


import android.util.Log
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.context.Auth
import com.example.core.scanner.viewmodels.ScanViewModel
import com.example.qrscanner.Scanner
import com.example.ws.network.ScannerHandler
import kotlinx.coroutines.launch
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

@Composable
fun CameraScan(
    viewModelCameraScan: ScanViewModel = viewModel(),
    onSuccessfulCameraScan: () -> Unit,
    scanHandlerCamera: ScannerHandler
){
    val context = LocalContext.current
    val scanner = remember { Scanner(context) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        val codeResults = scanner.codeResult.collectAsStateWithLifecycle()
        Scan(
            scanner::startScan,
            codeResults.value,
            viewModelCameraScan,
            onSuccessfulCameraScan,
            scanHandlerCamera
        )
    }

}

@Composable
private fun Scan(
    onScan: suspend () -> Unit,
    value: String?,
    viewModelCameraScan: ScanViewModel = viewModel(),
    onSuccessfulCameraScan: () -> Unit,
    scanHandlerCamera: ScannerHandler
){
    viewModelCameraScan.key = value
    val jwt = Auth.loggedInUser?.jwt
    viewModelCameraScan.jwt = jwt
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(400.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .defaultMinSize(minWidth = 80.dp)
                .height(50.dp),
            onClick = {
                scope.launch{
                    onScan()
                }
        }) {
            Text(
                text = "Scan code",
                color = Color.White,
                style = MaterialTheme.typography.button
            )
        }
        if (value != null){
            viewModelCameraScan.scan(
                scanHandlerCamera,
                onSuccessfulScan = onSuccessfulCameraScan,
                onFailedScan = {}
            )
        }
    }
}

