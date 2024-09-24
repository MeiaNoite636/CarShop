package com.meianoitedev.carshop.home_feature.domain.use_case

import com.meianoitedev.carshop.home_feature.data.source.mapper.toCarPresentation
import com.meianoitedev.carshop.home_feature.domain.model.CarPresentation
import com.meianoitedev.carshop.home_feature.domain.repository.CarsRepository
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(
    private val carsRepository: CarsRepository
) {
    suspend operator fun invoke(): List<CarPresentation> {
        return carsRepository.getCars().map { it.toCarPresentation() }
    }
}