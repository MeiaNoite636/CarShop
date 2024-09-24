package com.meianoitedev.carshop.util

sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val message: String? = null, val exception: Throwable? = null) :
        Resource<Nothing>()
}
