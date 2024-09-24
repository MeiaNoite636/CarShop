package com.meianoitedev.carshop.ui.components.card.car_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorUnselectedIconBottomNavBar

@Composable
fun SecondToLastRowCard(
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        MyText(
            fontWeight = FontWeight(600),
            fontSize = fontSize,
            colorText = ColorUnselectedIconBottomNavBar,
            textTitle = stringResource(id = R.string.text_price_card_item)
        )

        MyText(
            fontWeight = FontWeight(600),
            fontSize = fontSize,
            colorText = ColorUnselectedIconBottomNavBar,
            textTitle = stringResource(id = R.string.text_year_card_item)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LastRowCardPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SecondToLastRowCard(
            fontSize = 18.sp
        )
    }
}