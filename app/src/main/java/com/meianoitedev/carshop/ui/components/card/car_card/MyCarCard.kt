package com.meianoitedev.carshop.ui.components.card.car_card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.home_feature.domain.model.CarPresentation
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorUnselectedIconBottomNavBar

@Composable
fun MyCarCard(
    modifier: Modifier = Modifier,
    onBookMarkClick: () -> Unit,
    car: CarPresentation,
    onNavigateToDetailScreen: () -> Unit,
    width: Dp
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .width(width),
        onClick = onNavigateToDetailScreen,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            pressedElevation = 12.dp,
            focusedElevation = 12.dp,
            hoveredElevation = 12.dp,
            defaultElevation = 8.dp
        ),
        content = {
            Column(
                modifier = modifier.padding(16.dp)
            ) {
                FirstRowCard(
                    onClick = onBookMarkClick,
                    title = car.modelName,
                    colorTextTitle = Color.Black,
                    fontSize = 16.sp,
                    iconEnd = painterResource(id = R.drawable.ic_favorite_heart)
                )
                MyText(
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp,
                    colorText = ColorUnselectedIconBottomNavBar,
                    textTitle = car.fuel
                )

                Spacer(modifier = modifier.padding(top = 32.dp))

                SecondToLastRowCard(
                    modifier = modifier.height(20.dp),
                    fontSize = 14.sp
                )

                LastRowCard(car = car, fontSize = 14.sp)
            }
        }
    )
}

@Preview
@Composable
private fun MyCarCardPreview() {
    MyCarCard(
        onBookMarkClick = {},
        car = CarPresentation(
            year = 2012,
            fuel = "DIESEL",
            id = 12,
            price = 12.000,
            modelName = "COROLLA"
        ),
        onNavigateToDetailScreen = {},
        width = 250.dp
    )
}