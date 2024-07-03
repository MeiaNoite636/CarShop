package com.meianoitedev.carshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.meianoitedev.carshop.presentation.MainScreen
import com.meianoitedev.carshop.ui.theme.CarShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarShopTheme {
                MainScreen(navController = rememberNavController())
            }
        }
    }
}

