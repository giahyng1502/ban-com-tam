package com.giahyng.ricefood.ui.theme

import android.graphics.drawable.Icon
import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.Screen.LoginScreen
import com.giahyng.ricefood.Screen.RegisterScreen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.coroutines.CoroutineContext
import kotlin.collections.List as List1


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = primaryColor,
    textColor: Color = Color.White,
    cornerRadius: Dp = 12.dp, // Bán kính góc mặc định
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .padding(16.dp)
            .fillMaxWidth(),Alignment.Center
    ) {
        Text(text = text, color = textColor, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    value: String,
    cornerRadius: Dp,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
) {
    Column(modifier = modifier.padding(5.dp)) {
        Text(text = label, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder) },
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White),
            colors = outlinedTextFieldColors(
                focusedBorderColor = primaryColor, // Viền màu xanh khi được focus
                unfocusedBorderColor = Gray, // Viền màu xám khi không được focus // Màu nhãn khi được focus
                cursorColor = primaryColor // Màu của con trỏ nhập liệu
            ),
            textStyle = TextStyle(fontSize = 18.sp),
            shape = RoundedCornerShape(cornerRadius) // Góc bo tròn cho TextField
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    label: String,
    value: String,
    placeholder: String = "",
    cornerRadius: Dp,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(5.dp)) {
        Text(text = label, style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White),
            placeholder = { Text(placeholder) },
            isError = isError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = primaryColor, // Viền khi focus
                unfocusedBorderColor = Gray, // Viền khi không focus
                cursorColor = primaryColor // Màu con trỏ
            ),
            textStyle = TextStyle(fontSize = 18.sp),
            shape = RoundedCornerShape(cornerRadius), // Bo góc
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(), // Hiển thị hoặc ẩn mật khẩu
            trailingIcon = {
                val image = if (isPasswordVisible) {
                    painterResource(id = R.drawable.view) // Icon khi hiển thị mật khẩu
                } else {
                    painterResource(id = R.drawable.hide) // Icon khi ẩn mật khẩu
                }
                // Chỉ chuyển đổi trạng thái khi nhấn vào biểu tượng
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible // Chuyển đổi hiển thị/ẩn mật khẩu
                }) {
                    Icon(painter = image, contentDescription = null, modifier = Modifier.size(20.dp))
                }
            }
        )
    }
}

@Composable
fun CenterContent(
    value: String,
    textColor: Color,
    onClick: () -> Unit = {}, // Hàm callback khi nhấn
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth().padding(20.dp)
            .clickable(onClick = onClick),
        // Thêm khả năng nhấn
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = value, color = textColor, fontSize = 18.sp) // Hiển thị giá trị trong Text
    }
}

@Composable
fun CustomLayoutWithDividers(
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth() ,
            verticalAlignment = Alignment.CenterVertically // Căn giữa theo chiều dọc
    ) {
        // Divider bên trái
        Divider(
            modifier = Modifier
                .weight(1f) // Chiếm đều không gian với Divider bên phải
                .height(1.dp),
            color = Color.Gray // Màu của Divider
        )

        // Nội dung ở giữa
        Text(
            text = value,
            modifier = Modifier.padding(horizontal = 8.dp ) ,// Khoảng cách giữa Divider và nội dung
            fontSize = 18.sp
        )

        // Divider bên phải
        Divider(
            modifier = Modifier
                .weight(1f) // Chiếm đều không gian với Divider bên trái
                .height(1.dp),
            color = Color.Gray // Màu của Divider
        )
    }
}
@Composable
fun ButtonWithIcon(
    iconResId: Int, // Nhận ID của icon từ drawable
    value: String,
    onClick: () -> Unit,
    cornerRadius: Dp = 16.dp,
    backgroundColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor), // Đặt màu nền cho nút
        shape = RoundedCornerShape(cornerRadius), // Đặt góc bo tròn
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp, pressedElevation = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center , // Nội dung căn giữa
        ) {
            // Biểu tượng bên trái từ drawable
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null, // Bạn có thể thêm mô tả cho accessibility
                modifier = Modifier.size(40.dp) // Đặt kích thước cho icon
            )
            Spacer(modifier = Modifier.width(8.dp)) // Khoảng cách giữa biểu tượng và văn bản

            // Văn bản bên phải
            Text(text = value, color = Black, fontSize = 18.sp)
        }
    }
}


