package com.example.airexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airexpress.screens.EntryScreen
import com.example.airexpress.screens.registration.RegistrationScreen
import com.example.airexpress.ui.theme.AiRexpressTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AiRexpressTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "entry"){
                        composable("entry"){
                            EntryScreen(
                                onRegistrationButtonClick = {
                                    navController.navigate("register")
                                }
                            )
                        }

                        composable("register"){
                            RegistrationScreen(
                                onSuccessfulRegistration = {
                                        newEmail -> navController.navigate("entry")
                                    /*
                                    * TODO
                                    *  in the line send the navigation to login screen
                                    * */
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}
