package com.meianoitedev.carshop.auth.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: String? = null
) {
    fun isNotEmpty(): Boolean = email.isNotEmpty() && password.isNotEmpty()
}