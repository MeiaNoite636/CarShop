package com.meianoitedev.carshop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import com.meianoitedev.carshop.navigation.auth.AUTH_GRAPH_ROUTE
import com.meianoitedev.carshop.navigation.auth.AuthGraphItem
import com.meianoitedev.carshop.navigation.auth.authGraph
import com.meianoitedev.carshop.navigation.bottom_bar.BOTTOM_BAR_GRAPH_ROUTE
import com.meianoitedev.carshop.navigation.bottom_bar.bottomNavGraph
import com.meianoitedev.carshop.navigation.details_nav.DETAILS_GRAPH_ROUTE
import com.meianoitedev.carshop.navigation.details_nav.detailsGraph


@Composable
fun MainGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE
    ) {

        authGraph(
            onNavigateToRegister = {
                navController.navigateToRegisterScreen()
            },
            onForgotPasswordClick = {
                navController.navigateToRecoverScreen()
            },
            loginToHomeGraph = {
                navController.navigateToBottomGraph(
                    navOptions {
                        popUpTo(AUTH_GRAPH_ROUTE) {
                            inclusive = true
                        }
                    }
                )
            },
            registerToHomeGraph = {
                navController.navigateToBottomGraph(
                    navOptions {
                        popUpTo(AUTH_GRAPH_ROUTE) {
                            inclusive = true
                        }
                    }
                )
            }
        )

        bottomNavGraph(
            onNavigateToDetails = {
                navController.navigate(route = DETAILS_GRAPH_ROUTE)
            }
        )

        detailsGraph()
    }
}


//Extension Functions to navController.navigate
fun NavHostController.navigateToRegisterScreen(){
    navigate(route = AuthGraphItem.Register.route)
}

fun NavHostController.navigateToRecoverScreen(){
    navigate(route = AuthGraphItem.Recover.route)
}


fun NavHostController.navigateToBottomGraph(navOptions: NavOptions? = null){
    navigate(route = BOTTOM_BAR_GRAPH_ROUTE, navOptions)
}

