package com.meianoitedev.carshop.domain.repository.car

import com.meianoitedev.carshop.data.source.remote.response.CarResponse

interface CarRepository {
    suspend fun getCars(): CarResponse
}