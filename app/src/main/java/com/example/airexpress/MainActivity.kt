package com.example.airexpress

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.context.Auth
import com.example.airexpress.screens.EntryScreen
import com.example.airexpress.screens.HomeScreen
import com.example.airexpress.screens.LoginScreen
import com.example.airexpress.screens.ProductEdit
import com.example.airexpress.screens.RegistrationScreen
import com.example.airexpress.ui.theme.AiRexpressTheme
import com.example.ws.network.ScannerHandler
import com.example.qrscanner.screens.qrScannerScreen
import com.example.textrecognitionscanner.textRecognitionScanner
import com.example.ws.network.EmailPasswordLoginHandler

class MainActivity : ComponentActivity() {
    private val loginHandlers = listOf(EmailPasswordLoginHandler())
    private val currentLoginHandler = loginHandlers[0]
    private val scanHandlers = listOf(ScannerHandler())
    private val currentScanHandler = scanHandlers[0]

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
                                onSuccessfulLogin = {
                                    navController.navigate("home")
                            },
                                loginHandler = currentLoginHandler
                            )
                        }
                        composable("home"){
                            HomeScreen(
                                onQrCodeButtonClick = {
                                    navController.navigate("qr")
                                },
                                onTextButtonClick = {
                                    navController.navigate("textRecognition")
                                },
                                onLogoutButtonClick = {
                                    Auth.loggedInUser = null
                                    navController.navigate("entry")
                                }
                            )
                        }
                        composable("qr"){
                            qrScannerScreen(
                                onSuccessfulScan = {
                                    navController.navigate("product-edit")
                                },
                                scanHandler = currentScanHandler
                            )
                        }
                        composable("product-edit"){
                            ProductEdit(
                                onSuccessfulEdit = {
                                        newEdit -> navController.navigate("home")
                                }
                            )
                        }
                        composable("textRecognition"){
                            textRecognitionScanner(
                                onSuccessfulScan = {
                                    navController.navigate("product-edit")
                                },
                                scanHandler = currentScanHandler
                            )
                        }
                    }
                }
            }
        }
    }
}
