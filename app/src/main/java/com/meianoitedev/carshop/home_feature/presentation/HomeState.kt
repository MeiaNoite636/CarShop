package com.meianoitedev.carshop.home_feature.presentation

import com.meianoitedev.carshop.home_feature.domain.model.CarPresentation

data class HomeState(
    val cars: List<CarPresentation> = emptyList()
)

