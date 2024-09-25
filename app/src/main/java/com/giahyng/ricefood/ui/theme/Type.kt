package com.giahyng.ricefood.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.2.sp,
        color = Black
    ),
    bodySmall = TextStyle(
        fontSize = 16.sp,
        color = Black
    ),

)