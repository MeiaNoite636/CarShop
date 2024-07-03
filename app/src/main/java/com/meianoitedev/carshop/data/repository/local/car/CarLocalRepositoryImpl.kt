package com.meianoitedev.carshop.data.repository.local.car

import com.meianoitedev.carshop.data.source.local.dao.CarDao
import com.meianoitedev.carshop.data.source.local.entity.CarEntity
import com.meianoitedev.carshop.domain.repository.local.CarLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarLocalRepositoryImpl @Inject constructor(
    private val carDao: CarDao
) : CarLocalRepository {
    override fun getCars(): Flow<List<CarEntity>> {
        return carDao.getCars()
    }

    override suspend fun insertCar(carEntity: CarEntity) {
        return carDao.insertCar(carEntity)
    }
}