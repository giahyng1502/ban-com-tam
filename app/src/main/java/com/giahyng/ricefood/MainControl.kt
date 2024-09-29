package com.giahyng.ricefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.giahyng.ricefood.Screen.Cart
import com.giahyng.ricefood.Screen.FavoriteScreen
import com.giahyng.ricefood.Screen.HomeScreen
import com.giahyng.ricefood.Screen.Myprofile
import com.giahyng.ricefood.Screen.ProfileDetail
import com.giahyng.ricefood.Screen.SearchViewScreen
import com.giahyng.ricefood.Screen.cardScreen
import com.giahyng.ricefood.Screen.productDetail
import com.giahyng.ricefood.ui.Typography

class MainControl : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                    AppNavHost()
//                HomeScreen()
//                productDetail()
//                Cart()
//                SearchViewScreen()
//            FavoriteScreen()
//            Myprofile()
//            ProfileDetail()
        }
    }
}
