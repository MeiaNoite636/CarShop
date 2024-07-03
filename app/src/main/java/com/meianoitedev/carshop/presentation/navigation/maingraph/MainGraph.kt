package com.meianoitedev.carshop.presentation.navigation.maingraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meianoitedev.carshop.presentation.auth.login.screen.LoginScreen
import com.meianoitedev.carshop.presentation.auth.register.screen.RegisterScreen


@Composable
fun MainGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AuthScreen.Login.route) {
        composable(AuthScreen.Login.route) {
            LoginScreen(
                onNavigateToRegister = { },
                onForgotPasswordClick = { },
                onLoginSuccess = {

                }
            )
        }

        composable(AuthScreen.Register.route) {
            LoginScreen(
                onNavigateToRegister = { },
                onForgotPasswordClick = { },
                onLoginSuccess = {

                }
            )
        }
    }
}
