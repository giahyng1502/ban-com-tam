package com.giahyng.ricefood.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.model.Product
import com.giahyng.ricefood.ui.CustomItemFood
import com.giahyng.ricefood.ui.gray
import com.giahyng.ricefood.ui.hintColor
import com.giahyng.ricefood.ui.itemsColor
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.searchColor
import com.giahyng.ricefood.ui.textColorItems


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchViewScreen() {
    Column (modifier = Modifier.fillMaxSize()
        .background(color = primaryColor).padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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
                            androidx.compose.material3.Text(
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

        LazyColumn {
            items(products.chunked(4)) { product ->
                Column(modifier = Modifier.padding(16.dp)) {
                    product.forEachIndexed{index,product ->
                        CustomItemFood(product,index)
                    }
                }
            }
        }
    }
}
val  products = listOf(
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
//@Preview(showBackground = true)
//@Composable
//fun View() {
//    SearchViewScreen()
//}