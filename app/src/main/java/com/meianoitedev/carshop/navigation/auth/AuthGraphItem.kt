package com.meianoitedev.carshop.navigation.auth

sealed class AuthGraphItem(val route: String) {
    data object Login : AuthGraphItem("login_screen")
    data object Register : AuthGraphItem("register_screen")
    data object Recover: AuthGraphItem("recover_screen")
}