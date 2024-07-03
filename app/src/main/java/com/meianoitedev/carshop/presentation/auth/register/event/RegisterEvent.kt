package com.meianoitedev.carshop.presentation.auth.register.event

sealed class RegisterEvent {
    data object Success : RegisterEvent()
    data class Error(val message: String) : RegisterEvent()
}