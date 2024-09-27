package com.giahyng.ricefood.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.giahyng.ricefood.R
import com.giahyng.ricefood.model.Category
import com.giahyng.ricefood.model.Product
import com.giahyng.ricefood.ui.CustomItem
import com.giahyng.ricefood.ui.ImageCirc
import com.giahyng.ricefood.ui.Typography
import com.giahyng.ricefood.ui.ImageCorner
import com.giahyng.ricefood.ui.ImageSlider
import com.giahyng.ricefood.ui.customCategory
import com.giahyng.ricefood.ui.primaryColor

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it) // padding từ Scaffold để tránh tràn qua bottomBar
        ) {
        }
    }
}


@Composable
fun HomeScreen () {
    val rememberScrollState = rememberScrollState()
    val name = "Hoàng Văn Hưng"// tên người dùng đăng nhập hiện tại
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().verticalScroll(rememberScrollState)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .height(45.dp),
            Arrangement.Absolute.Left,
            Alignment.CenterVertically
        )
        {
            ImageCirc(
                painter = painterResource(R.drawable.hungcy),
                cornerRadius = 100.dp,
                borderStroke = 0.5.dp
            )
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Xin chào", fontSize = 14.sp)
                Text(
                    name,
                    color = primaryColor,
                    style = Typography.bodySmall,
                    fontWeight = FontWeight(700)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                // list ảnh
                val imageList = listOf(
                    R.drawable.comtam,
                    R.drawable.comtam2
                )
                ImageSlider(imageList, 5000)
            }
        }
        Spacer(Modifier.height(10.dp))
            Column(Modifier.height(230.dp).fillMaxWidth()) {
                Text(text = "Hôm nay ăn gì?", style = Typography.titleLarge, modifier = Modifier.padding(15.dp,0.dp))
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow {
                    items(categorys.chunked(1)) { category ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (categorys in categorys) {
                                customCategory(categorys)
                            }
                        }
                    }
                }
            }
            Spacer(Modifier.height(10.dp))
            Column(Modifier.height(370.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Món ăn ngon nhất", style = Typography.titleLarge)
                    Text(
                        text = "Xem thêm >",
                        style = Typography.bodySmall,
                        color = primaryColor,
                        fontWeight = FontWeight(700)
                    )
                }
                LazyRow {
                    items(list.chunked(1)) { products ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (product in list) {
                                CustomItem(product)
                            }
                        }
                    }
                }
            }
        }
    }
val list = listOf(
    Product(name = "Cơm rang sườn",
        price = 100000.0, image = R.drawable.comtam,
        rating = 4.9,
        description = "Cơm rang sườn với thịt nướng đặc biệt",
        isFavorite = false,
        categoryId = "CT1"),
    Product(name = "Cơm rang sườn",
        price = 100000.0, image = R.drawable.comtam,
        rating = 4.9,
        description = "Cơm rang sườn với thịt nướng đặc biệt",
        isFavorite = false, categoryId = "CT1"),
    Product(name = "Cơm rang sườn",
        price = 100000.0, image = R.drawable.comtam,
        rating = 4.9,
        description = "Cơm rang sườn với thịt nướng đặc biệt",
        isFavorite = false,
        categoryId = "CT2"),
)
val categorys = listOf(
    Category(id = "CT1", name = "Cơm rang", icon = R.drawable.category),
    Category(id = "CT1", name = "Mì", icon = R.drawable.category),
    Category(id = "CT1", name = "Phở", icon = R.drawable.category),
    Category(id = "CT1", name = "Cháo", icon = R.drawable.category),
)

@Composable
fun MapScreen () {

}

@Composable
fun CartScreen () {

}

@Composable
fun FavoriteScreen () {

}

@Composable
fun NotificationScreen () {

}
//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    MaterialTheme(
//        typography = Typography,
//    ) {
//    HomeScreen()
//    }
//}
