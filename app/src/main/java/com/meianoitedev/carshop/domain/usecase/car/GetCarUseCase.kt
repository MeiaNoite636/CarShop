package com.meianoitedev.carshop.domain.usecase.car

import com.meianoitedev.carshop.data.source.remote.mapper.toDomain
import com.meianoitedev.carshop.domain.model.CarPresentation
import com.meianoitedev.carshop.domain.repository.car.CarRepository
import javax.inject.Inject

class GetCarUseCase @Inject constructor(
    private val carRepository: CarRepository
) {
    suspend operator fun invoke(): List<CarPresentation> {
        return carRepository.getCars().toDomain()
    }
}