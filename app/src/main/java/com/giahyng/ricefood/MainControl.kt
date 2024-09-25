package com.giahyng.ricefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.giahyng.ricefood.ui.theme.Typography

class MainControl : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                typography = Typography
            ) {
                    AppNavHost()
            }
        }
    }
}
