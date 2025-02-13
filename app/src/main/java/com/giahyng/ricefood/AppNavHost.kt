package com.giahyng.ricefood

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.giahyng.ricefood.Screen.Cart
import com.giahyng.ricefood.Screen.FavoriteScreen
import com.giahyng.ricefood.Screen.HomeScreen
import com.giahyng.ricefood.Screen.Myprofile
import com.giahyng.ricefood.Screen.OrderHistory
import com.giahyng.ricefood.Screen.TabLoginAndRegister
import com.giahyng.ricefood.Screen.productDetail
import com.giahyng.ricefood.ui.hintColor
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.textColorItems

@Composable
fun AppNavHost(navController: NavHostController,innerPadding : PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "login",
        Modifier.padding(innerPadding)
    ) {
        navigation(startDestination = "home",route = "buttom_navigation") {
            composable("home") { HomeScreen(navController) }
            composable("favourite") { FavoriteScreen(navController) }
            composable("cart") { Cart() }
            composable("profile") { Myprofile(navController) }
        }
        composable("login") { TabLoginAndRegister(navController) }
        composable("order") { OrderHistory() }

        composable(
            "product_detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("id").toString()
            productDetail(productId,navController)
        }

    }
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("home", "Home", Icons.Default.Home),
        BottomNavItem("favourite", "Favourite", Icons.Default.Favorite),
        BottomNavItem("cart", "Cart", Icons.Default.ShoppingCart),
        BottomNavItem("profile", "Profile", Icons.Default.Person)
    )

    BottomNavigation(
        backgroundColor = primaryColor,
        modifier = Modifier.height(100.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected = currentRoute == item.route // Kiểm tra xem có được chọn không
            val iconColor = if (isSelected) textColorItems else hintColor
            BottomNavigationItem(
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                icon = { Icon(item.icon, contentDescription = item.title, tint = iconColor, modifier = Modifier.size(32.dp)) },
                label = { Text(item.title) },
                selected = isSelected ,
                onClick = {
                    navController.navigate(item.route) {
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

data class BottomNavItem(val route: String, val title: String, val icon: ImageVector)
