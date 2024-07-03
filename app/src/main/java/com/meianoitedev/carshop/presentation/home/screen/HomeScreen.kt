package com.meianoitedev.carshop.presentation.home.screen

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
import com.meianoitedev.carshop.domain.model.CarPresentation
import com.meianoitedev.carshop.presentation.components.card.CardItem
import com.meianoitedev.carshop.presentation.home.state.HomeState
import com.meianoitedev.carshop.presentation.home.viewmodel.HomeViewModel
import com.meianoitedev.carshop.presentation.uistate.UiState

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.homeState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCars()
    }

    HomeScreenContent(
        modifier = modifier,
        uiState = state
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    uiState: UiState<HomeState>
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
                fontSize = 18.sp
            )
            Text(
                text = stringResource(id = R.string.text_row_right_home_screen),
                fontWeight = FontWeight(600),
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        when (uiState) {
            is UiState.Loading -> CircularProgressIndicator()
            is UiState.Success -> CarList(
                cars = uiState.data.cars,
                navigateToDetails = {}
            )
            is UiState.Error -> Text("Error: ${uiState.message}")
        }
    }
}

@Composable
fun CarList(
    cars: List<CarPresentation>,
    navigateToDetails: () -> Unit
) {
    LazyRow {
        items(cars) { car ->
            CardItem(
                car = car,
                width = 200.dp,
                navToDetailScreen = {navigateToDetails()})
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
            uiState = UiState.Success(
                HomeState(
                    cars = listOf(
                        CarPresentation(
                            year = 2020,
                            fuel = "DIESEL",
                            color = "blue",
                            id = 2,
                            modelName = "CORSA CLASSIC",
                            doorsNumber = 4,
                            registerTimestamp = 12,
                            price = 12.000
                        )
                    )
                )
            )
        )
    }
}
