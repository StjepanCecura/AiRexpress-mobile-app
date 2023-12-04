package com.example.airexpress.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.airexpress.R



@Composable
fun EntryScreen (
    onRegistrationButtonClick: () -> Unit,
    onLoginButtonClick: () -> Unit
){
    Scaffold (
        topBar = {
            Surface(
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.airexpresslogo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(70.dp)
                )
            }
        },
        bottomBar = {
            Text(
                text = "AiRExpress",
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text(
                text = "Welcome to AiRExpress app",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )
            Button(
                onClick = onLoginButtonClick,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(50.dp)
            ){
                Text(
                    text = "Login",
                    color = Color.White,
                    style = MaterialTheme.typography.button
                )
            }
            Button(
                onClick = onRegistrationButtonClick,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .defaultMinSize(minWidth = 80.dp)
                    .height(50.dp)
            ){
                Text(
                    text = "Register",
                    color = Color.White,
                    style = MaterialTheme.typography.button,

                )
            }
        }
    }
}