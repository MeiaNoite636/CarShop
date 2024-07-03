package com.meianoitedev.carshop.presentation.navigation.maingraph

sealed class AuthScreen(
    val route: String
){
    data object Login: AuthScreen("login_screen")
    data object Register: AuthScreen("register_screen")
    data object Recover: AuthScreen("recover_screen")
}