package com.meianoitedev.carshop.car_details_feature.presentation.details.event

sealed class CarDetailsEvent {
    data object Success : CarDetailsEvent()
    data class Error(val message: String) : CarDetailsEvent()
}