package com.meianoitedev.carshop.auth.presentation.register

sealed class RegisterEvent {
    data object Success : RegisterEvent()
    data class Error(val message: String) : RegisterEvent()
}