package com.meianoitedev.carshop.domain.repository.local

import com.meianoitedev.carshop.data.source.local.entity.CarEntity
import kotlinx.coroutines.flow.Flow

interface CarLocalRepository {

    fun getCars(): Flow<List<CarEntity>>

    suspend fun insertCar(carEntity: CarEntity)
}