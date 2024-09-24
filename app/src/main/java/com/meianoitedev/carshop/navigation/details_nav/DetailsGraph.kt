package com.meianoitedev.carshop.navigation.details_nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.meianoitedev.carshop.car_details_feature.presentation.details.screen.DetailsScreen

const val DETAILS_GRAPH_ROUTE = "details_graph"

fun NavGraphBuilder.detailsGraph() {
    navigation(
        route = DETAILS_GRAPH_ROUTE,
        startDestination = DetailsGraphItem.Details.route
    ) {
        detailsScreenComposable()
    }
}

fun NavGraphBuilder.detailsScreenComposable(){
    composable(route = DetailsGraphItem.Details.route) {
        DetailsScreen()
    }

}