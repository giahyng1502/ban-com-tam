package com.giahyng.ricefood.Screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.giahyng.ricefood.R
import com.giahyng.ricefood.ui.ButtonWithIcon
import com.giahyng.ricefood.ui.CenterContent
import com.giahyng.ricefood.ui.CustomButton
import com.giahyng.ricefood.ui.CustomLayoutWithDividers
import com.giahyng.ricefood.ui.CustomTextField
import com.giahyng.ricefood.ui.PasswordTextField
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.white

@Composable
fun TabLoginAndRegister(navController: NavController?) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Đăng Nhập", "Đăng Ký")
    Column {
        Column(
            modifier = Modifier
                .weight(0.7f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        primaryColor, shape = RoundedCornerShape(
                            0, 0,
                            10, 10
                        )
                    )
                    .padding(20.dp, 1.dp),
                Alignment.BottomCenter
            ) {

                TabRow(selectedTabIndex = tabIndex,
                    modifier = Modifier.background(primaryColor),
                    indicator = { tabPositions -> // Tùy chỉnh đường kẻ dưới
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                            color = white  // Đặt màu cho đường kẻ dưới
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = {
                                Text(title, fontSize = 18.sp, color = white) },
                            selected = tabIndex == index,
                            modifier = Modifier.background(primaryColor),
                            onClick = { tabIndex = index},
                        )
                    }
                }

            }
        }
        // Hiệu ứng ra vào cho nội dung
        AnimatedVisibility(visible = tabIndex == 0) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .weight(2.2f),
                verticalArrangement = Arrangement.Center
            ) {
                // Nội dung cho Đăng Nhập
                LoginScreen(navController)
            }
        }

        AnimatedVisibility(visible = tabIndex == 1) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .weight(2.2f),
                verticalArrangement = Arrangement.Center
            ) {
                // Nội dung cho Đăng Ký
                RegisterScreen()
            }
        }

        Column (Modifier.weight(0.7f)){
            CustomLayoutWithDividers("Hoặc")
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
                ButtonWithIcon(iconResId = R.drawable.google,
                    "Google", onClick = {
                        //Xử lý đăng nhập bằng google
                    })
                ButtonWithIcon(iconResId = R.drawable.facebook,
                    "Facebook", onClick = {
                        //Xử lý đăng nhập bằng facebook
                    })
            }
        }
    }
}

@Composable
fun LoginScreen(navController: NavController?) {
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    CustomTextField(
        label = "E-mail",
        value = user,
        cornerRadius = 8.dp,
        onValueChange = {
            user = it
        },
        placeholder = "E-mail hoặc số điện thoại"
    )

    PasswordTextField(
        label = "Mật khẩu",
        value = pass,
        cornerRadius = 8.dp,
        onValueChange = {
            pass = it
        },
        placeholder = "Mật khẩu"
    )

    CenterContent("Quên mật khẩu ?", primaryColor, onClick = {
        //Viết hàm onclick khi người dùng quên mật khẩu tại đây
    })
    // nút button login
    CustomButton(text = "Đăng Nhập", cornerRadius = 16.dp, onClick = {
        // Xử lí logic đăng nhập ở đây
        navController?.navigate("mainScreen")
    })

}

@Composable
fun RegisterScreen() {
    var hoten by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var validPass by remember { mutableStateOf("") }
    CustomTextField(label = "Họ tên",
        value = hoten,
        cornerRadius = 8.dp,
        onValueChange = {
        hoten = it
    },
        placeholder = "Nhập đầy đủ cả họ và tên"
    )
    CustomTextField(label = "E-mail",
        value = email,
        cornerRadius = 8.dp,
        onValueChange = {
            email = it
        },
        placeholder = "E-mail hoặc số điện thoại"
    )
    PasswordTextField(
        label = "Mật khẩu",
        value = pass,
        cornerRadius = 8.dp,
        onValueChange = {
            pass = it
        },
        placeholder = "Mật khẩu"
    )
    PasswordTextField(
        label = "Nhập lại mật khẩu",
        value = validPass,
        cornerRadius = 8.dp,
        onValueChange = {
            validPass = it
        },
        placeholder = "Nhập lại mật khẩu để xác minh"
    )
    Spacer(Modifier.height(15.dp))
    CustomButton(text = "Đăng Ký", cornerRadius = 16.dp, onClick = {
        // Xử lí logic đăng ký ở đây
    })

}
//@Preview(showBackground = true)
//@Composable
//fun View() {
//    MaterialTheme(
//        typography = com.giahyng.ricefood.ui.theme.Typography,
//    ) {
//            LoginScreen(null)
//    }
//}