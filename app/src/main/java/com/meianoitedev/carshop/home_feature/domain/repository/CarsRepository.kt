package com.meianoitedev.carshop.home_feature.domain.repository

import com.meianoitedev.carshop.home_feature.data.source.response.Car

interface CarsRepository {
    suspend fun getCars(): List<Car>
}