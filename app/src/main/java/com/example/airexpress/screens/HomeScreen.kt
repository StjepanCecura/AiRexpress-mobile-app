package com.example.airexpress.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.airexpress.R
import com.example.qrscanner.screens.qrScannerScreenButton
import com.example.textrecognitionscanner.textRecognitionScannerButton
import com.example.ws.network.ScannerHandler

@Composable
fun HomeScreen(
    onQrCodeButtonClick: () -> Unit,
    onTextButtonClick: () -> Unit,
    onLogoutButtonClick: () -> Unit
){

    val gumbovi: List<@Composable () -> Unit> = listOf(
        {
            qrScannerScreenButton (onQrCodeButtonClick)
        },
        {
            textRecognitionScannerButton(onTextButtonClick)
        },
    )

    Scaffold (
        topBar = {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.airexpresslogosmall),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(250.dp)
                )
            }
        },
        bottomBar = {
            Text(
                text = "AiRExpress",
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            gumbovi.forEach { gumb -> Unit

                gumb()
                Spacer(modifier = Modifier.height(20.dp))

            }

            Button(
                onClick = onLogoutButtonClick,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(50.dp),
            ) {
                Text(
                    text = "Logout",
                    color = Color.White,
                )
            }
        }

    }
}