package com.meianoitedev.carshop.presentation.navigation.homegraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meianoitedev.carshop.presentation.favorite.screen.FavoriteScreen
import com.meianoitedev.carshop.presentation.home.screen.HomeScreen
import com.meianoitedev.carshop.presentation.profile.screen.ProfileScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(route = BottomNavItem.Home.route){
            HomeScreen()
        }
        composable(route = BottomNavItem.Favorite.route){
            FavoriteScreen()
        }
        composable(route = BottomNavItem.Profile.route){
            ProfileScreen()
        }
    }
}