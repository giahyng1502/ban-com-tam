package com.giahyng.ricefood.Screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.ui.CustomButton
import com.giahyng.ricefood.ui.ImageCorner
import com.giahyng.ricefood.ui.Typography
import com.giahyng.ricefood.ui.black
import com.giahyng.ricefood.ui.customBox
import com.giahyng.ricefood.ui.gray
import com.giahyng.ricefood.ui.hintColor
import com.giahyng.ricefood.ui.plushAndminus
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.textColorItems
import com.giahyng.ricefood.ui.textDescription
import com.giahyng.ricefood.ui.white

class cardScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryColor)
    ) {
        // Tiêu đề "Cart"
        Text(
            text = "Cart",
            style = Typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Column trên cùng (danh sách các item trong giỏ hàng)
        Column(
            modifier = Modifier
                .weight(1f) // Chiếm toàn bộ không gian trống
        ) {
            Box(Modifier.padding(10.dp)){
                cartItem()

            }
            Box(Modifier.padding(10.dp)){
                cartItem()

            }
            Box(Modifier.padding(10.dp)){
                cartItem()

            }

        }
        // Column dưới cùng
        Row (modifier = Modifier.fillMaxWidth().padding(15.dp)
            , horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(
                    text = "Tổng tiền : ",
                    fontSize = 18.sp,
                    color = white,
                    maxLines = 2
                )
                Text(
                    text = "30000000 VND",
                    fontSize = 18.sp,
                    color = white,
                    fontWeight = FontWeight(700),
                    maxLines = 1
                )
            }
            Box(modifier = Modifier.padding(10.dp).width(150.dp)){
                CustomButton(text = "Thanh Toán", cornerRadius = 20.dp, onClick ={
                    // Xử lí logic thanh toán ở đây
                })
            }
        }
    }
}


@Composable
fun cartItem() {
    customBox (content = {
        var quantity: Int = 1
        Row(modifier = Modifier.fillMaxWidth().height(130.dp).padding(5.dp, 10.dp)) {
            ImageCorner(
                painter = painterResource(R.drawable.comtam), cornerRadius = 16.dp,
                modifier = Modifier
                    .weight(1f)
            )
            Column(modifier = Modifier.padding(start = 16.dp).weight(2f)) {
                Text(
                    text = "Cơm rang sườn",
                    fontSize = 22.sp,
                    color = white,
                    maxLines = 1,
                    fontWeight = FontWeight(700)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "100000 VND", fontSize = 18.sp, color = white, maxLines = 1)
                Row(
                    modifier = Modifier.align(alignment = Alignment.End).padding(horizontal = 5.dp)
                ) {
                    plushAndminus(value = "+",
                        textcolor = white,
                        backgroundColor = primaryColor,
                        onClick = {
                            if (quantity < 20) {
                                quantity++
                            }
                        })
                    Text(
                        text = "2", fontSize = 20.sp, color = white,
                        modifier = Modifier.padding(8.dp, 0.dp)
                            .align(Alignment.CenterVertically)
                    )
                    plushAndminus(value = "-", textcolor = white, backgroundColor = textColorItems,
                        onClick = {
                            if (quantity > 1) {
                                quantity--
                            }
                        })
                }
            }
        }
    })
}

