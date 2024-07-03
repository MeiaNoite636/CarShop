package com.meianoitedev.carshop.presentation.navigation.homegraph

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector
import com.meianoitedev.carshop.R

sealed class BottomNavItem(
    @StringRes val title: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String,
    val hasNews: Boolean
) {
    data object Home : BottomNavItem(
        title = R.string.text_bottom_nav_home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = "home_screen",
        hasNews = false
    )

    data object Favorite : BottomNavItem(
        title = R.string.text_bottom_nav_favorite,
        selectedIcon = Icons.Rounded.Favorite,
        unselectedIcon = Icons.Rounded.FavoriteBorder,
        route = "favorite_screen",
        hasNews = true
    )

    data object Profile : BottomNavItem(
        title = R.string.text_bottom_nav_profile,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        route = "profile_screen",
        hasNews = false
    )
}