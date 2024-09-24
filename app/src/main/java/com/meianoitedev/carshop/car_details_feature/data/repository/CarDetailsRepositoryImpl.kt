package com.meianoitedev.carshop.car_details_feature.data.repository

import com.meianoitedev.carshop.car_details_feature.domain.repository.CarDetailsRepository
import com.meianoitedev.carshop.home_feature.data.source.CarsRemoteDataSource
import com.meianoitedev.carshop.home_feature.data.source.response.Car
import javax.inject.Inject

class CarDetailsRepositoryImpl @Inject constructor(
    private val carsRemoteDataSource: CarsRemoteDataSource
): CarDetailsRepository {
    override suspend fun getCarById(id: Int): Car {
        return carsRemoteDataSource.getCarById(id)
    }
}