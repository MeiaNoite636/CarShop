package com.meianoitedev.carshop.presentation.navigation.homegraph

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite,
        BottomNavItem.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        items.forEachIndexed { index: Int, bottomNavItem: BottomNavItem ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == bottomNavItem.route } == true,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(bottomNavItem.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    NavigationIcon(
                        bottomNavItem = bottomNavItem,
                        selectedItemIndex = selectedItemIndex,
                        index = index
                    )
                },
                label = {
                    Text(text = stringResource(bottomNavItem.title))
                }
            )
        }
    }
}

@Composable
fun NavigationIcon(bottomNavItem: BottomNavItem, selectedItemIndex: Int, index: Int) {
    BadgedBox(
        badge = {
            if (bottomNavItem.hasNews) Badge()
        }
    ) {
        Icon(
            imageVector = if (selectedItemIndex == index) {
                bottomNavItem.selectedIcon
            } else {
                bottomNavItem.unselectedIcon
            },
            contentDescription = null
        )
    }
}