package com.giahyng.ricefood.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.giahyng.ricefood.R
import com.giahyng.ricefood.model.Category
import com.giahyng.ricefood.model.Product
import com.giahyng.ricefood.ui.CustomItemFood
import com.giahyng.ricefood.ui.ImageCirc
import com.giahyng.ricefood.ui.Typography
import com.giahyng.ricefood.ui.ImageSlider
import com.giahyng.ricefood.ui.gray
import com.giahyng.ricefood.ui.hintColor
import com.giahyng.ricefood.ui.itemsColor
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.searchColor
import com.giahyng.ricefood.ui.textColorItems
import com.giahyng.ricefood.ui.white

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen () {
    val rememberScrollState = rememberScrollState()
    val name = "Hoàng Văn Hưng"// tên người dùng đăng nhập hiện tại
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = primaryColor)
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
                borderStroke = 0.5.dp
            )
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Xin chào", fontSize = 14.sp, color = white)
                Text(
                    name,
                    color = white,
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
        var query by remember { mutableStateOf("") }
        var isFocused by remember { mutableStateOf(false) }
        val focusManager = LocalFocusManager.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 10.dp)
                .background(searchColor, RoundedCornerShape(8.dp)) // Shape vẫn giữ nguyên
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // Icon tìm kiếm
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = hintColor
                )

                Spacer(modifier = Modifier.width(8.dp))

                // BasicTextField cho phần nhập liệu
                BasicTextField(
                    value = query,
                    onValueChange = {
                        query = it
                    },
                    cursorBrush = SolidColor(textColorItems), // Đ
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .onFocusChanged {
                            isFocused = it.isFocused // Cập nhật trạng thái focus
                        },
                    textStyle = TextStyle(
                        color = textColorItems, // Thay đổi màu chữ khi gõ
                        fontSize = 18.sp
                    ),
                    decorationBox = { innerTextField ->
                        if (query.isEmpty()) {
                            Text(
                                text = "Hôm nay bạn muốn ăn gì?",
                                color = hintColor
                            )
                        }
                        innerTextField() // Hiển thị nội dung nhập liệu
                    }
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Icon đóng
                if (isFocused) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = null,
                        tint = hintColor,

                        modifier = Modifier.clickable {
                            query = "" // Xóa nội dung tìm kiếm
                            focusManager.clearFocus()
                        }
                    )
                }
            }
        }

        var selectedTabIndex by remember { mutableStateOf(0) }
        Spacer(Modifier.height(10.dp))
            Column(Modifier.height(370.dp)
            ) {
                Column {
                    // LazyRow để tạo một hàng các tab có thể cuộn
                    LazyRow {
                        items(categorys.size) { index ->
                            Tab(
                                selected = selectedTabIndex == index,
                                onClick = { selectedTabIndex = index }, // Cập nhật chỉ số tab được chọn
                                text = {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Text(
                                            text = categorys[index].name,
                                            color = if (selectedTabIndex == index) textColorItems else hintColor // Màu sắc dựa vào trạng thái chọn
                                        )
                                        Box(
                                            modifier = Modifier.padding(top = 8.dp)
                                                .width(10.dp) // Đặt chiều rộng cho Divider
                                                .height(10.dp) // Đặt chiều cao cho Divider
                                                .background(if (selectedTabIndex == index) textColorItems else Color.Transparent, shape = CircleShape) // Chỉ hiển thị màu khi tab được chọn
                                        )
                                    }
                                       },
                                modifier = Modifier.padding(8.dp),
                                enabled = true,
                                selectedContentColor = textColorItems,
                                unselectedContentColor = gray
                            )
                        }
                    }
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
