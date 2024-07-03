package com.meianoitedev.carshop.presentation.components.card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CarFuelType(fuel: String) {
    Text(
        text = fuel,
        fontSize = 16.sp,
        color = Color.Gray,
        fontWeight = FontWeight(700)
    )
}