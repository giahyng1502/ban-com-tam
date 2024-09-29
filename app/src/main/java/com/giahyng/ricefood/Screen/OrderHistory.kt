package com.giahyng.ricefood.Screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.model.Product
import com.giahyng.ricefood.ui.CustomItemFood
import com.giahyng.ricefood.ui.historyFood
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.white

@Composable
fun OrderHistory() {
    var scrollState = rememberScrollState()
    Column(Modifier.background(primaryColor).padding(10.dp)) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Lịch sử đặt hàng", fontSize = 26.sp, color = white, fontWeight = FontWeight.Bold)

        }
        Column(Modifier.verticalScroll(scrollState)) {
            historyFood(product)
            historyFood(product)
            historyFood(product)
            historyFood(product)
    }
}
}


val product = Product(name = "Cơm rang sườn",
    price = 100000.0, image = R.drawable.comtam,
    rating = 4.9,
    description = "Cơm rang sườn với thịt nướng đặc biệt",
    isFavorite = false,
    categoryId = "CT2")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrderHistory()
}