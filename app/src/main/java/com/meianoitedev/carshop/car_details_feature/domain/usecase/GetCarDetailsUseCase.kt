package com.meianoitedev.carshop.car_details_feature.domain.usecase

import com.meianoitedev.carshop.car_details_feature.domain.model.CarDetailsPresentation
import com.meianoitedev.carshop.car_details_feature.domain.repository.CarDetailsRepository
import com.meianoitedev.carshop.home_feature.data.source.mapper.toCarDetailsPresentation
import javax.inject.Inject

class GetCarDetailsUseCase @Inject constructor(
    private val carDetailsRepository: CarDetailsRepository
) {
    suspend operator fun invoke(id: Int): CarDetailsPresentation{
        return carDetailsRepository.getCarById(id).toCarDetailsPresentation()
    }
}