package com.meianoitedev.carshop.car_details_feature.presentation.details.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.car_details_feature.presentation.details.state.CarDetailsState
import com.meianoitedev.carshop.car_details_feature.presentation.details.viewmodel.CarDetailsViewModel
import com.meianoitedev.carshop.ui.components.button.MyButton
import com.meianoitedev.carshop.ui.components.column.ColumnIconTextText
import com.meianoitedev.carshop.ui.components.row.RowIconText
import com.meianoitedev.carshop.ui.components.text.MyText
import com.meianoitedev.carshop.ui.theme.ColorBackground
import com.meianoitedev.carshop.ui.theme.ColorCerulian
import com.meianoitedev.carshop.ui.theme.ColorPrice
import com.meianoitedev.carshop.ui.theme.ColorPrussianBlue
import com.meianoitedev.carshop.ui.theme.ColorUnselectedIconBottomNavBar


@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier
) {
    val carDetailsViewModel: CarDetailsViewModel = hiltViewModel()
    val carDetails by carDetailsViewModel.carDetailsState.collectAsState(initial = CarDetailsState())

    val scope = rememberCoroutineScope()

    var showProgressBar by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        carDetailsViewModel.getCarDetails(1)
    }



}

@Composable
fun DetailsScreenContent(
    modifier: Modifier = Modifier,
    carDetails: CarDetailsState,
    showProgressBar: Boolean
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        MyText(
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            colorText = ColorPrussianBlue,
            textTitle = carDetails.modelName
        )

        MyText(
            fontWeight = FontWeight(900),
            fontSize = 16.sp,
            colorText = ColorPrice,
            textTitle = "$ ${carDetails.price}"
        )

        Spacer(modifier = modifier.padding(top = 32.dp))

        ColumnIconTextText(
            modifier = modifier,
            icon = painterResource(id = R.drawable.ic_newcalendar),
            data = carDetails.registerTimestamp
        )

        Spacer(modifier = modifier.padding(top = 32.dp))

        MyText(
            fontWeight = FontWeight(900),
            fontSize = 16.sp,
            colorText = ColorPrussianBlue,
            textTitle = "Overview"
        )

        MyText(
            fontWeight = FontWeight(500),
            fontSize = 14.sp,
            colorText = ColorUnselectedIconBottomNavBar,
            textTitle = "A car, or an automobile, is a motor vehicle with wheels. Most definitions of cars state that they run primarily on roads, seat one to eight people, have four wheels, and mainly transport people over cargo."
        )

        Spacer(modifier = modifier.padding(top = 32.dp))

        MyText(
            fontWeight = FontWeight(900),
            fontSize = 16.sp,
            colorText = ColorPrussianBlue,
            textTitle = "Features"
        )

        Spacer(modifier = modifier.padding(top = 8.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RowIconText(
                icon = painterResource(id = R.drawable.ic_color),
                data = carDetails.color
            )

            RowIconText(
                icon = painterResource(id = R.drawable.ic_car_door),
                data = carDetails.doorsNumber
            )

            RowIconText(
                icon = painterResource(id = R.drawable.ic_fuel),
                data = carDetails.fuel
            )
        }

        Spacer(modifier = modifier.padding(top = 16.dp))

        Row (
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            if(showProgressBar) CircularProgressIndicator(color = Color.Black, strokeWidth = 1.dp)
        }

        Column(
            modifier = modifier
                .padding(bottom = 40.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            MyButton(
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonColors(
                    containerColor = ColorCerulian,
                    contentColor = ColorBackground,
                    disabledContentColor = ColorBackground,
                    disabledContainerColor = ColorPrussianBlue,
                ),
                textButton = "I want it",
                onClick = {},
                fontWeightText = FontWeight(700),
                fontSizeText = 14.sp,
                colorText = ColorBackground
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    DetailsScreenContent(
        modifier = Modifier,
        carDetails = CarDetailsState(
            year = 2020,
            fuel = "DIESEL",
            id = 2,
            modelName = "CORSA CLASSIC",
            price = 12.000,
            registerTimestamp = 0,
            color = "White",
            doorsNumber = 4
        ),
        showProgressBar = true
    )
}