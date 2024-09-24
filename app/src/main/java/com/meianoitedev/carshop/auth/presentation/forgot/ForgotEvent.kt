package com.meianoitedev.carshop.auth.presentation.forgot

sealed class ForgotEvent {
    data object Success : ForgotEvent()
    data class Error(val message: String) : ForgotEvent()
}