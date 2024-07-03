package com.meianoitedev.carshop.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.meianoitedev.carshop.presentation.navigation.homegraph.BottomNavigationBar
import com.meianoitedev.carshop.presentation.navigation.homegraph.NavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        content = {
            NavGraph(
                navController = navController
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    )
}