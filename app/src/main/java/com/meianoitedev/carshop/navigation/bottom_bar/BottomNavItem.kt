package com.meianoitedev.carshop.navigation.bottom_bar

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.meianoitedev.carshop.R

@SuppressLint("SupportAnnotationUsage")
sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: String,
    val hasNews: Boolean
) {
    data object Home : BottomNavItem(
        title = R.string.text_bottom_nav_home,
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home_line,
        route = "home_screen",
        hasNews = false
    )

    data object Favorite : BottomNavItem(
        title = R.string.text_bottom_nav_favorite,
        selectedIcon = R.drawable.ic_favorite_filled,
        unselectedIcon = R.drawable.ic_favorite_line,
        route = "favorite_screen",
        hasNews = true
    )

    data object Profile : BottomNavItem(
        title = R.string.text_bottom_nav_profile,
        selectedIcon = R.drawable.ic_user_filled,
        unselectedIcon = R.drawable.ic_user_line,
        route = "profile_screen",
        hasNews = false
    )
}