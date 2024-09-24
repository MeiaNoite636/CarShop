package com.meianoitedev.carshop.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.meianoitedev.carshop.auth.presentation.login.LoginScreen
import com.meianoitedev.carshop.auth.presentation.forgot.RecoverScreen
import com.meianoitedev.carshop.auth.presentation.register.RegisterScreen


const val AUTH_GRAPH_ROUTE = "auth"

fun NavGraphBuilder.authGraph(
    onNavigateToRegister: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    loginToHomeGraph: () -> Unit,
    registerToHomeGraph: () -> Unit
) {
    navigation(
        route = AUTH_GRAPH_ROUTE,
        startDestination = AuthGraphItem.Login.route
    ){
        composable(route = AuthGraphItem.Login.route) {
            LoginScreen(
                onNavigateToRegister = onNavigateToRegister,
                onForgotPasswordClick = onForgotPasswordClick,
                loginToHomeGraph = loginToHomeGraph
            )
        }
        composable(
            route = AuthGraphItem.Register.route,
        ) {
            RegisterScreen(
                registerToHomeGraph = registerToHomeGraph
            )
        }
        composable(route = AuthGraphItem.Recover.route) {
            RecoverScreen()
        }
    }
}