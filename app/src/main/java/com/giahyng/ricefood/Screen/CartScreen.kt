package com.giahyng.ricefood.Screen

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.giahyng.ricefood.ui.gray
import com.giahyng.ricefood.ui.plushAndminus
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.textDescription
import com.giahyng.ricefood.ui.white
import java.time.format.TextStyle

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
            .padding(5.dp)
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
            cartItem()
            cartItem()
            cartItem()
        }
        Column(Modifier.weight(0.3f)
            .fillMaxWidth()
            .background(color = gray, shape = RoundedCornerShape(16.dp,16.dp)),
            verticalArrangement = Arrangement.Center
        ) {
            Row(Modifier.padding(10.dp)) {
                Text(text = "Tổng tiền : 100.000 VND", color = black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Row(Modifier.padding(10.dp)) {
                Text(text = "Phí vận chuyển : 5.000 VND", color = black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Row(Modifier.padding(10.dp)){
                Text(text = "Thành tiền  : 105.000 VND", color = black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(0.dp,10.dp)) {
            androidx.compose.material3.OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Mã giảm giá") },
                modifier = Modifier
                    .weight(0.7f)
                    .background(Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = primaryColor, // Viền màu xanh khi được focus
                    unfocusedBorderColor = gray, // Viền màu xám khi không được focus // Màu nhãn khi được focus
                    cursorColor = primaryColor // Màu của con trỏ nhập liệu
                ),
                textStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp),
                shape = RoundedCornerShape(16.dp) // Góc bo tròn cho TextField
            )
            CustomButton(text = "Áp dụng", modifier = Modifier.weight(0.3f).padding(5.dp)
                ,onClick = {
                // Xử lí logic áp dụng mã giảm giá ở đây
            }, backgroundColor = black)
        }

        // Column dưới cùng
        CustomButton(text = "Thanh Toán", onClick ={
            // Xử lí logic thanh toán ở đây
        })
    }
}


@Composable
fun cartItem() {
    var quantity : Int = 1
    Row(modifier = Modifier.fillMaxWidth().height(130.dp).padding(5.dp,10.dp)) {
        ImageCorner(painter = painterResource(R.drawable.comtam), cornerRadius = 16.dp,
            modifier = Modifier
                .weight(1f)
        )
        Column(modifier = Modifier.padding(start = 16.dp).weight(2f)) {
            Text(text = "Cơm rang sườn", fontSize = 22.sp, color = black, maxLines = 1,fontWeight = FontWeight(700)  )
            Spacer(modifier = Modifier.height(5.dp))
            textDescription("Cơm rang sườn với thịt nướng đặc biệt", maxline = 2,size = 18.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Row(modifier = Modifier.fillMaxWidth().height(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,) {
                Text(text = "100000 VND", fontSize = 18.sp, color = primaryColor, maxLines = 1)
                Row {
                    plushAndminus(value = "+", textcolor = white, backgroundColor = primaryColor,
                        onClick ={
                            if (quantity < 20) {
                                quantity++
                            }
                        })
                    Text(text = "2", fontSize = 20.sp, color = black,
                        modifier = Modifier.padding(8.dp,0.dp).align(Alignment.CenterVertically)
                    )
                    plushAndminus(value = "-", textcolor = black, backgroundColor = white,
                        onClick ={
                            if (quantity > 1) {
                                quantity--
                            }
                        })
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Cart()
//}