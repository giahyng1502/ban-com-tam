package com.giahyng.ricefood.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.ui.CustomItemFood
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.white

@Composable
fun FavoriteScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(primaryColor)
    ) {
        Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            Text("Món ăn yêu thích", fontSize = 26.sp, fontWeight = FontWeight(700) ,color = white, modifier = Modifier.padding(top = 24.dp))
        }
        LazyColumn {
            items(list.chunked(list.size)) { foods ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    foods.forEachIndexed{index,food ->
                        CustomItemFood(food,index)
                    }
                }
            }
        }
    }
}