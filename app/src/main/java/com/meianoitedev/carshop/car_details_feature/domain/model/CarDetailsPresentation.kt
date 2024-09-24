package com.meianoitedev.carshop.car_details_feature.domain.model

data class CarDetailsPresentation(
    val year: Int,
    val fuel: String,
    val id: Int,
    val modelName: String,
    val price: Double,
    val doorsNumber: Int,
    val registerTimestamp: Long,
    val color: String
)