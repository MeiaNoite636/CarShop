package com.meianoitedev.carshop.navigation.bottom_bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meianoitedev.carshop.favorite_feature.presentation.FavoriteScreen
import com.meianoitedev.carshop.home_feature.presentation.HomeScreen
import com.meianoitedev.carshop.profile_feature.presentation.ProfileScreen
import com.meianoitedev.carshop.ui.theme.ColorSelectedIconBottomNavBar
import com.meianoitedev.carshop.ui.theme.ColorUnselectedIconBottomNavBar
import com.meianoitedev.carshop.ui.theme.myCustomFont


const val BOTTOM_BAR_GRAPH_ROUTE = "bottom_bar_navigation"


fun NavGraphBuilder.bottomNavGraph(
    onNavigateToDetails: () -> Unit
) {
    composable(BOTTOM_BAR_GRAPH_ROUTE) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val items = remember {
            listOf(
                BottomNavItem.Home,
                BottomNavItem.Favorite,
                BottomNavItem.Profile
            )
        }

        var selectedItemIndex by remember {
            mutableIntStateOf(0)
        }


        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Home.route,
                Modifier.weight(1f)
            ) {
                homeScreenComposable(onNavigateToDetails = onNavigateToDetails)

                favoriteScreenComposable()

                profileScreenComposable()
            }

            NavigationBar {
                items.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        icon = {
                            NavigationIcons(
                                bottomNavItem = screen,
                                selectedItemIndex = selectedItemIndex,
                                index = index
                            )
                        },
                        label = {
                            Text(
                                stringResource(screen.title),
                                fontWeight = FontWeight(800),
                                fontFamily = myCustomFont,
                                fontSize = 14.sp
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            selectedItemIndex = index

                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    }
}

fun NavGraphBuilder.homeScreenComposable(
    onNavigateToDetails: () -> Unit
) {
    composable(BottomNavItem.Home.route) {
        HomeScreen(onNavigateToDetails = onNavigateToDetails)
    }
}

fun NavGraphBuilder.favoriteScreenComposable() {
    composable(BottomNavItem.Favorite.route) {
        FavoriteScreen()
    }
}

fun NavGraphBuilder.profileScreenComposable() {
    composable(BottomNavItem.Profile.route) {
        ProfileScreen(
            name = "William dos Santos",
            email = "John@gmail.com",
            onNavigateToRequests = {}
        )
    }
}

@Composable
fun NavigationIcons(bottomNavItem: BottomNavItem, selectedItemIndex: Int, index: Int) {
    BadgedBox(
        badge = {
            if (bottomNavItem.hasNews) Badge()
        }
    ) {
        Icon(
            painter = painterResource(
                id = if (selectedItemIndex == index) {
                    bottomNavItem.selectedIcon
                } else {
                    bottomNavItem.unselectedIcon
                }
            ),
            tint = if (selectedItemIndex == index) ColorSelectedIconBottomNavBar else ColorUnselectedIconBottomNavBar,
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
    }
}
