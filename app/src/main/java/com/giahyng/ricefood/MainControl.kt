package com.giahyng.ricefood

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainControl : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        MainScreen(navController = navController)
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScreen(navController: NavHostController) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        // Chỉ hiển thị BottomNavigationBar trên các màn hình trong BottomNavigation
        val bottomBarScreens = listOf("home", "favourite", "cart", "profile")

        Scaffold(
            bottomBar = {
                if (currentRoute in bottomBarScreens) {
                    BottomNavigationBar(navController = navController)
                }
            }
        ) {innerPadding ->
            AppNavHost(navController = navController,innerPadding)
        }
    }
}
