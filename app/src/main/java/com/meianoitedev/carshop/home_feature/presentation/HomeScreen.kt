package com.meianoitedev.carshop.home_feature.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meianoitedev.carshop.R
import com.meianoitedev.carshop.home_feature.domain.model.CarPresentation
import com.meianoitedev.carshop.ui.components.card.car_card.MyCarCard
import com.meianoitedev.carshop.util.Resource
import com.meianoitedev.carshop.ui.theme.ColorSelectedIconBottomNavBar
import com.meianoitedev.carshop.ui.theme.myCustomFont

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetails: () -> Unit
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.homeState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCars()
    }

    HomeScreenContent(
        modifier = modifier,
        resource = state,
        onNavigateToDetails = onNavigateToDetails
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    resource: Resource<HomeState>,
    onNavigateToDetails: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.text_row_left_home_screen),
                fontWeight = FontWeight(600),
                fontSize = 18.sp,
                fontFamily = myCustomFont
            )
            Text(
                modifier = modifier.clickable {  },
                text = stringResource(id = R.string.text_row_right_home_screen),
                fontWeight = FontWeight(600),
                color = Color.Gray,
                fontSize = 14.sp,
                fontFamily = myCustomFont
            )
        }

        when (resource) {
            is Resource.Loading -> CircularProgressIndicator(
                color = ColorSelectedIconBottomNavBar,
                strokeWidth = 2.dp
            )
            is Resource.Success -> CarList(
                cars = resource.data.cars,
                navigateToDetails = onNavigateToDetails
            )

            is Resource.Error -> Text("Error: ${resource.message}")
        }
    }
}

@Composable
fun CarList(
    cars: List<CarPresentation>,
    navigateToDetails: () -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(cars) { car ->
            MyCarCard(
                onBookMarkClick = {

                },
                car = car,
                onNavigateToDetailScreen = navigateToDetails,
                width = 200.dp
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenContentPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeScreenContent(
            resource = Resource.Success(
                HomeState(
                    cars = listOf(
                        CarPresentation(
                            year = 2020,
                            fuel = "DIESEL",
                            id = 2,
                            modelName = "CORSA CLASSIC",
                            price = 12.000
                        )
                    )
                )
            ),
            onNavigateToDetails = {}
        )
    }
}
