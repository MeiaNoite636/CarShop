package com.meianoitedev.carshop.presentation.uistate

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String? = null, val exception: Throwable? = null) :
        UiState<Nothing>()
}