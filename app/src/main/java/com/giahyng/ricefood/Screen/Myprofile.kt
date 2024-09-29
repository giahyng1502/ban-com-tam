package com.giahyng.ricefood.Screen

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.ui.CustomButton
import com.giahyng.ricefood.ui.CustomItemProfilee
import com.giahyng.ricefood.ui.CustomTextField
import com.giahyng.ricefood.ui.ImageCirc
import com.giahyng.ricefood.ui.ImageCorner
import com.giahyng.ricefood.ui.Typography
import com.giahyng.ricefood.ui.hintColor
import com.giahyng.ricefood.ui.itemsColor
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.white

@Composable
fun Myprofile() {
    var scrollState = rememberScrollState()
    Column(Modifier.fillMaxSize().background(primaryColor).verticalScroll(scrollState)) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 10.dp)) {
            ImageCirc(painter = painterResource(id = R.drawable.hungcy), width = 180.dp)

        }
        Spacer(Modifier.height(20.dp))
        Column(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Text("Hoàng Văn Hưng", style = Typography.titleLarge, color = white)
            Spacer(Modifier.height(10.dp))
            CustomItemProfilee(iconResId = R.drawable.ic_personadetail,"Thông tin chi tiết","Thông tin cá nhân của bạn", icon2 = R.drawable.right)
            CustomItemProfilee(iconResId = R.drawable.ic_history,"Lịch sử","Thông tin đơn hàng bạn đã đặt", icon2 = R.drawable.right)
            CustomItemProfilee(iconResId = R.drawable.ic_paypel,"Thanh toán","Thanh toán cho hóa đơn của bạn", icon2 = R.drawable.right)
            CustomItemProfilee(iconResId = R.drawable.ic_changepass,"Thay đổi mật khẩu","Đổi mật khẩu cho tài khoản này", icon2 = R.drawable.right)
            CustomItemProfilee(iconResId = R.drawable.ic_logout,"Đăng xuất","Rời khỏi tài khoản này", icon2 = R.drawable.right)

        }
    }
}
@Composable
fun ProfileDetail() {
    Column(Modifier.fillMaxSize().background(primaryColor), verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 10.dp)) {
            ImageCirc(painter = painterResource(id = R.drawable.hungcy), width = 180.dp)
            Box(Modifier.align(Alignment.BottomEnd).padding(5.dp)) {
                Box(Modifier.clip(CircleShape)
                    .background(white)
                    .size(38.dp)

                ) {
                    Icon(painter = painterResource(R.drawable.ic_camera)
                        ,contentDescription = "",
                        tint = hintColor,
                        modifier = Modifier.size(24.dp).align(Alignment.Center)
                    )
                }
            }

        }
        Column (Modifier.padding(horizontal = 10.dp)){
            var name by remember { mutableStateOf("") }
            CustomTextField(label = "Họ và tên",
                value = name,
                placeholder = "Nhập đầy đủ cả họ và tên",
                cornerRadius = 16.dp,
                onValueChange = {
                    name = it
                }
            )
            var phonumber by remember { mutableStateOf("") }
            CustomTextField(label = "Số điện thoại",
                value = phonumber,
                placeholder = "Nhập số điện thoại của bạn",
                cornerRadius = 16.dp,
                onValueChange = {
                    phonumber = it
                }
            )
            var address by remember { mutableStateOf("") }
            CustomTextField(label = "Địa chỉ",
                value = address,
                placeholder = "Nhập địa chỉ bạn đang sống",
                cornerRadius = 16.dp,
                onValueChange = {
                    address = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton(text = "Thay đổi ", onClick = {
                // Xử lí logic thay đ��i thông tin ở đây
            })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun viewpr() {
    ProfileDetail()
}