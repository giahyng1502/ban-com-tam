package com.giahyng.ricefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.giahyng.ricefood.Screen.Cart
import com.giahyng.ricefood.Screen.HomeScreen
import com.giahyng.ricefood.Screen.cardScreen
import com.giahyng.ricefood.Screen.productDetail
import com.giahyng.ricefood.ui.Typography

class MainControl : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                typography = Typography
            ) {
//                    AppNavHost()
//                HomeScreen()
//                productDetail()
                Cart()
            }

        }
    }
}
