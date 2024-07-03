package com.meianoitedev.carshop.domain.model

data class CarPresentation(
    val year: Int,
    val fuel: String,
    val color: String,
    val id: Int,
    val modelName: String,
    val doorsNumber: Int,
    val registerTimestamp: Long,
    val price: Double
)