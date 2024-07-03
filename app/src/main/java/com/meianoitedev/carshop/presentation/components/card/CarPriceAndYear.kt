package com.meianoitedev.carshop.presentation.components.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.domain.model.CarPresentation

@Composable
fun CarPriceAndYear(car: CarPresentation) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.text_price_card_item),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color.Gray
            )
            Text(
                text = stringResource(id = R.string.text_ano_card_item),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color.Gray
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "R$ ${car.price}00",
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )
            Text(
                text = car.year.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}