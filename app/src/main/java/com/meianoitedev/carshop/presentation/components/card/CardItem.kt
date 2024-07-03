package com.meianoitedev.carshop.presentation.components.card

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.meianoitedev.carshop.domain.model.CarPresentation

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    car: CarPresentation,
    width: Dp,
    navToDetailScreen: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp)
            .width(width)
            .wrapContentHeight(),
        onClick = navToDetailScreen,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        CarCardContent(
            car = car
        )
    }
}


