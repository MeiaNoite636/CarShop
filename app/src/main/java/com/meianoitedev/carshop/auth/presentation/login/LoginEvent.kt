package com.meianoitedev.carshop.auth.presentation.login

sealed interface LoginEvent {
    data object Login : LoginEvent
    data object EmptyEmail : LoginEvent
    data class EmailChanged(val email: String) : LoginEvent
    data class PasswordChanged(val password: String) : LoginEvent
}