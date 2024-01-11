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
import com.example.qrscanner.Scanner
import kotlinx.coroutines.launch

@Composable
fun CameraScan(

){
    lateinit var scanner: Scanner
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraController = remember { LifecycleCameraController(context) }
    scanner = Scanner(context)

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        val codeResults = scanner.codeResult.collectAsStateWithLifecycle()
        Scan(
            scanner::startScan,
            codeResults.value
        )
    }

}

@Composable
private fun Scan(
    onScan: suspend () -> Unit,
    value: String?
){
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
                    Log.i("Scope launch", "Scope started")
                    onScan()
                }
        }) {
            Text(
                text = "Scan code",
                color = Color.White,
                style = MaterialTheme.typography.button
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = value ?: "00000000",
            style = MaterialTheme.typography.h4
        )
        
    }
}

