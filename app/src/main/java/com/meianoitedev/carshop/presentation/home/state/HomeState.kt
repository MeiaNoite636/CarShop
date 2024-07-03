package com.meianoitedev.carshop.presentation.home.state

import com.meianoitedev.carshop.domain.model.CarPresentation

data class HomeState(
    val cars: List<CarPresentation> = emptyList()
)

