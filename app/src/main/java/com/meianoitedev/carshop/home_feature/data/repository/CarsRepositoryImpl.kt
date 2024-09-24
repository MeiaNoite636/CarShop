package com.meianoitedev.carshop.home_feature.data.repository

import com.meianoitedev.carshop.home_feature.data.source.CarsRemoteDataSource
import com.meianoitedev.carshop.home_feature.data.source.response.Car
import com.meianoitedev.carshop.home_feature.domain.repository.CarsRepository
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val carsRemoteDataSource: CarsRemoteDataSource
) : CarsRepository {
    override suspend fun getCars(): List<Car> {
        return carsRemoteDataSource.getCars()
    }
}