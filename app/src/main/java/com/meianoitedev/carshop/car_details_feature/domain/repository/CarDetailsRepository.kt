package com.meianoitedev.carshop.car_details_feature.domain.repository

import com.meianoitedev.carshop.home_feature.data.source.response.Car

interface CarDetailsRepository {
    suspend fun getCarById(id: Int): Car
}