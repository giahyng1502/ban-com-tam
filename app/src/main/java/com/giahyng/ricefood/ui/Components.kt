package com.giahyng.ricefood.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.model.Category
import com.giahyng.ricefood.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


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
                unfocusedBorderColor = gray, // Viền màu xám khi không được focus // Màu nhãn khi được focus
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
                unfocusedBorderColor = gray, // Viền khi không focus
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
            Text(text = value, color = black, fontSize = 18.sp)
        }
    }
}

@Composable
fun ImageCorner(
    painter: Painter,
    cornerRadius: Dp = 0.dp,
    width: Dp = 45.dp,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier.width(width)
            .clip(RoundedCornerShape(cornerRadius)),
        contentScale = ContentScale.Crop// Bo góc cho hình ảnh
    )
}
@Composable
fun ImageCirc(
    painter: Painter,
    cornerRadius: Dp = 0.dp,
    borderStroke: Dp = 0.dp,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier.width(45.dp)
            .border(width = borderStroke, color = primaryColor, shape =  RoundedCornerShape(cornerRadius))
            .clip(RoundedCornerShape(cornerRadius))
    )
}

@Composable
fun ImageSlider(images: List<Int>, autoSlideDuration: Long = 5000L) {
    val pagerState = rememberPagerState{images.size}

    // Auto slide logic
    LaunchedEffect(pagerState) {
        while (true) {
            yield()
            delay(autoSlideDuration)
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val image = images[page]
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(16.dp))
                .border(color = primaryColor, width = 0.dp,shape =  RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun textDescription(text: String, size: TextUnit, maxline : Int,) {
    Text(
        text = text,
        style = TextStyle(fontSize = size),
        maxLines = maxline,
        color = descriptionColor,
        overflow = TextOverflow.Ellipsis // Vùng text vượt quá dài s�� hiển thị...
    )
}

@Composable
fun CustomItem(product: Product) {
    // custom item
    ElevatedCard(
        elevation = CardDefaults.outlinedCardElevation(1.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(300.dp)
            .height(330.dp)
            .padding(5.dp, 0.dp)
            .background(color = white)
            .border(1.dp, gray, RoundedCornerShape(16.dp)),
    )
    {
        Column (Modifier.weight(1.2f)){
            ImageCorner(painter = painterResource(id = product.image),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(
                            16,
                            16,
                            0,
                            0
                        )
                    ),
            )
        }

        Column (
            Modifier
                .weight(1f)
                .padding(5.dp, 8.dp)){
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = product.name, fontSize = 22.sp, color = black, maxLines = 1,fontWeight = FontWeight(700)  )
            Spacer(modifier = Modifier.height(5.dp))
            textDescription(text = product.description, maxline = 2,size = 18.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "${product.price} VND", fontSize = 18.sp, color = primaryColor, maxLines = 1)
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "${product.rating}",
                    fontSize = 20.sp,
                    color = black, fontWeight = FontWeight(700),
                    modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp)
                )
                Image(painter = painterResource(R.drawable.baseline_star_24),
                    modifier = Modifier.size(18.dp), contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .background(color = primaryColor)
                    .width(40.dp)
                    .height(40.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "+", fontSize = 25.sp, color = white, fontWeight = FontWeight(700))
            }
        }
    }
}
@Composable
fun customCategory(category: Category) {
    // custom category
    ElevatedCard (modifier = Modifier
        .width(110.dp).padding(8.dp,0.dp)
        .background(
            color = white,
            shape = RoundedCornerShape(100.dp)
        ), shape = RoundedCornerShape(100.dp),

        elevation = CardDefaults.cardElevation(8.dp)) {
        Column(Modifier.width(180.dp)
            .weight(1.3f)
            .background(color = primaryColor),
            horizontalAlignment =  Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(painter = painterResource(id = category.icon), contentDescription = "",
                modifier = Modifier.width(100.dp).clip(shape = CircleShape),
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        Column(Modifier.weight(1f).padding(5.dp).fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${category.name}", fontSize =16.sp, color = black)
        }
    }
}
@Composable
fun plushAndminus(
    value: String,
    textcolor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Box(
        modifier = modifier
            .size(30.dp) // Kích thước của nút
            .background(backgroundColor, shape = CircleShape)
            .border(width = 1.dp, shape = CircleShape, color = primaryColor)// Màu nền và bo góc
            .clickable { onClick() }, // Sự kiện nhấn
        contentAlignment = Alignment.Center // Căn giữa nội dung bên trong Box
    ) {
        Text(
            text = value,
            color = textcolor,
            fontSize = 23.sp
        )
    }
}

