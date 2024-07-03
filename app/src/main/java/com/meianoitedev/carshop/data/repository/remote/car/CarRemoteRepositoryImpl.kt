package com.meianoitedev.carshop.data.repository.remote.car

import com.meianoitedev.carshop.data.source.remote.api.CarApi
import com.meianoitedev.carshop.data.source.remote.response.CarResponse
import com.meianoitedev.carshop.domain.repository.car.CarRepository
import javax.inject.Inject

class CarRemoteRepositoryImpl @Inject constructor(
    private val carApi: CarApi
) : CarRepository {
    override suspend fun getCars(): CarResponse {
        return carApi.getCars()
    }
}