package com.meianoitedev.carshop.presentation.components.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meianoitedev.carshop.domain.model.CarPresentation

@Composable
fun CarCardContent(car: CarPresentation) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CarHeader(car = car)
        CarFuelType(fuel = car.fuel)
        Spacer(modifier = Modifier.height(24.dp))
        CarPriceAndYear(car = car)
    }
}