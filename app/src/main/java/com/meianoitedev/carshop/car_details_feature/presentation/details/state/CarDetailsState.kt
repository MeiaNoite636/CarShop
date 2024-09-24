package com.meianoitedev.carshop.car_details_feature.presentation.details.state

data class CarDetailsState(
    val year: Int = 0,
    val fuel: String = "",
    val id: Int = 0,
    val modelName: String = "",
    val price: Double = 0.0,
    val doorsNumber: Int = 0,
    val registerTimestamp: Long = 0,
    val color: String = ""
)
