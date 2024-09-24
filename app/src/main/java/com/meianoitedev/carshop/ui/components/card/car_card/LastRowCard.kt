package com.meianoitedev.carshop.ui.components.card.car_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.home_feature.domain.model.CarPresentation
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorSelectedIconBottomNavBar


@Composable
fun LastRowCard(
    modifier: Modifier = Modifier,
    car: CarPresentation,
    fontSize: TextUnit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        MyText(
            textTitle = "R$ ${car.price}00",
            fontWeight = FontWeight(600),
            colorText = ColorSelectedIconBottomNavBar,
            fontSize = fontSize,
        )

        MyText(
            fontWeight = FontWeight(600),
            fontSize = fontSize,
            colorText = ColorSelectedIconBottomNavBar,
            textTitle = "${car.year}"
        )
        
    }
}

@Preview(showBackground = true)
@Composable
private fun LastRowCardPreview() {
    LastRowCard(
        car = CarPresentation(
            year = 2012,
            fuel = "DIESEL",
            id = 12,
            price = 12.000,
            modelName = "COROLLA"
        ),
        fontSize = 18.sp
    )
}