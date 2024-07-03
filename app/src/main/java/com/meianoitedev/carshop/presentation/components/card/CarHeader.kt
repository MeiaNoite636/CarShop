package com.meianoitedev.carshop.presentation.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.domain.model.CarPresentation
import com.meianoitedev.carshop.presentation.components.menu.FavoriteIcon

@Composable
fun CarHeader(
    car: CarPresentation
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = car.modelName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        FavoriteIcon()
    }
}