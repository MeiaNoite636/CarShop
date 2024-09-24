package com.meianoitedev.carshop.navigation.details_nav

sealed class DetailsGraphItem(val route: String) {
    data object Details : DetailsGraphItem("details_screen")
    data object ProfileDetails : DetailsGraphItem("profile_details_screen")
}