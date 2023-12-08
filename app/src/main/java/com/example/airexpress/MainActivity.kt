package com.example.airexpress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airexpress.screens.EntryScreen
import com.example.airexpress.screens.HomeScreen
import com.example.airexpress.screens.LoginScreen
import com.example.airexpress.screens.registration.RegistrationScreen
import com.example.airexpress.ui.theme.AiRexpressTheme
import com.example.ws.network.EmailPasswordLoginHandler

class MainActivity : ComponentActivity() {
    private val loginHandlers = listOf(EmailPasswordLoginHandler())
    private val currentLoginHandler = loginHandlers[0]

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
                                },
                                onLoginButtonClick ={
                                    navController.navigate("login")
                                }
                            )
                        }

                        composable("register"){
                            RegistrationScreen(
                                onSuccessfulRegistration = {
                                        newEmail -> navController.navigate("login")
                                }
                            )
                        }
                        composable("login"){
                            LoginScreen(
                                onSuccessfullLogin = {
                                    navController.navigate("home")
                            },
                                loginHandler = currentLoginHandler
                            )
                        }
                        composable("home"){
                            HomeScreen( //TODO insert navigation routes here
                                onQrCodeButtonClick = {

                                },
                                onBarcodeButtonClick = {

                                },
                                onTextButtonClick = {

                                },
                                onLogoutButtonClick = {
                                    navController.navigate("entry")
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}
