package com.meianoitedev.carshop.domain.usecase.local.car

import com.meianoitedev.carshop.data.source.local.entity.CarEntity
import com.meianoitedev.carshop.domain.repository.local.CarLocalRepository
import javax.inject.Inject

class InsertCarLocalUseCase @Inject constructor(
    private val carLocalRepository: CarLocalRepository
) {
    suspend operator fun invoke(carEntity: CarEntity){
        return carLocalRepository.insertCar(carEntity)
    }
}