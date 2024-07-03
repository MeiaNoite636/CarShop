package com.meianoitedev.carshop.domain.usecase.local.car

import com.meianoitedev.carshop.domain.repository.local.CarLocalRepository
import javax.inject.Inject

class GetCarsLocalUseCase @Inject constructor(
    private val carLocalRepository: CarLocalRepository
) {
    operator fun invoke() = carLocalRepository.getCars()
}