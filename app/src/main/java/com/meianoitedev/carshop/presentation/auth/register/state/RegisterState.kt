package com.meianoitedev.carshop.presentation.auth.register.state

data class RegisterState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = true
)