package com.example.qrscanner.screens

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.qrscanner.Scanner
import kotlinx.coroutines.launch


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
