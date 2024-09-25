package com.giahyng.ricefood

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.giahyng.ricefood.Screen.LoginScreen
import com.giahyng.ricefood.Screen.RegisterScreen
import com.giahyng.ricefood.Screen.TabLoginAndRegister


enum class ROUTE_NAME {
    Login,
    Home
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { TabLoginAndRegister(navController = navController) } }
    }