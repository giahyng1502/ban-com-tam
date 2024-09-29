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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
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
    backgroundColor: Color = textColorItems,
    textColor: Color = Color.White,
    padding: Dp = 16.dp,
    cornerRadius: Dp = 12.dp, // Bán kính góc mặc định
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .padding(padding)
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
        Text(text = label, fontSize = 16.sp, color = white)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder, color = hintColor) },
            modifier = modifier
                .fillMaxWidth()
                .background(itemsColor, shape = RoundedCornerShape(cornerRadius)),
            colors = outlinedTextFieldColors(
                focusedBorderColor = textColorItems, // Viền màu xanh khi được focus
                unfocusedBorderColor = primaryColor, // Viền màu xám khi không được focus // Màu nhãn khi được focus
                cursorColor = white, // Màu của con trỏ nhập liệu
                focusedTextColor = white, // Màu của chữ khi không focus
                unfocusedTextColor = white
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
        Text(text = label, fontSize = 16.sp, color = white)
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth()
                .background(itemsColor, shape = RoundedCornerShape(cornerRadius)),
            placeholder = { Text(placeholder) },
            isError = isError,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = textColorItems, // Viền khi focus
                unfocusedBorderColor = itemsColor, // Viền khi không focus
                cursorColor = white ,// Màu con trỏ
                focusedTextColor = white,
                unfocusedTextColor = white // Màu chữ khi không focus
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
            fontSize = 18.sp,
            color = white
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
fun ButtonWithIconRadius(
    iconResId: Int, // Nhận ID của icon từ drawable
    value: String,
    onClick: () -> Unit,
    cornerRadius: Dp = 100.dp,
    backgroundColor: Color = primaryColor
) {
    Button(
        modifier = Modifier.height(70.dp), // Đặt chiều cao cho nút
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
            Box (Modifier.clip(shape = CircleShape)
                .background(color = white, shape = CircleShape)
                .width(55.dp)
                .height(55.dp),
                Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = iconResId),
                    contentDescription = null, // Bạn có thể thêm mô tả cho accessibility
                    modifier = Modifier.size(32.dp) // Đặt kích thước cho icon
                )
            }
            Spacer(modifier = Modifier.width(8.dp)) // Khoảng cách giữa biểu tượng và văn bản

            // Văn bản bên phải
            Text(text = value, color = white, fontSize = 20.sp)
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
    width: Dp = 45.dp,
    painter: Painter,
    borderStroke: Dp = 0.dp,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier.width(width)
            .border(width = borderStroke, color = primaryColor, shape = CircleShape)
            .clip(CircleShape)
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
fun plushAndminus(
    value: String,
    textcolor: Color,
    onClick: () -> Unit,
    width: Dp = 30.dp,
    size: TextUnit = 23.sp,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    Box(
        modifier = modifier
            .size(width) // Kích thước của nút
            .background(backgroundColor, shape = CircleShape)
            .border(width = 1.dp, shape = CircleShape, color = textColorItems)// Màu nền và bo góc
            .clickable { onClick() }, // Sự kiện nhấn
        contentAlignment = Alignment.Center // Căn giữa nội dung bên trong Box
    ) {
        Text(
            text = value,
            color = textcolor,
            fontSize =size
        )
    }
}

@Composable
fun CustomItemFood(product: Product,index: Int) {
    // custom item food
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier
           .fillMaxWidth().padding(vertical = 10.dp)
           .height(110.dp),
        content = {
            customBox (content = {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth().fillMaxHeight().padding(10.dp)
                    ) {
                    Text(text = "${index + 1}", fontSize = 23.sp, color = white, modifier = Modifier.padding(start = 5.dp)  )
                    Image(
                        painter = painterResource(id = product.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.width(80.dp).height(80.dp).clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = product.name, fontSize = 20.sp, color = white, maxLines = 1)
                        Text(text = "${product.price} VND", fontSize = 20.sp, color = textColorItems)
                    }
                         plushAndminus(value = "+", textcolor = white, onClick = {
                            // xu ly khi click vao nút -
                        }, backgroundColor = textColorItems)

                }
            })
         })
}
@Composable
fun historyFood(product: Product) {
    // custom item food
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier
            .fillMaxWidth().padding(vertical = 10.dp)
            .height(280.dp),
        content = {
            customBox (height = 280.dp,content = {
                Column(Modifier.fillMaxSize()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                            .fillMaxWidth().padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = product.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.width(80.dp).height(80.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            modifier = Modifier.padding(vertical = 5.dp, horizontal = 8.dp)
                                .weight(1f),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(text = product.name, fontSize = 20.sp, color = white, maxLines = 1)
                            Text(
                                text = "${product.price} VND",
                                fontSize = 20.sp,
                                color = textColorItems
                            )
                        }
                        Text(text = "x2", fontSize = 22.sp, color = white)

                    }
                    HorizontalDivider(Modifier.fillMaxWidth(), color = gray)

                    Row(Modifier.padding(horizontal = 8.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "5 sản phẩm ", fontSize = 14.sp, color = gray,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                        Row {
                            Text(
                                text = "Thành tiền : ", fontSize = 14.sp, color = gray,
                                modifier = Modifier.padding(vertical = 10.dp)
                            )
                            Text(
                                text = "120K", fontSize = 14.sp, color = textColorItems,
                                modifier = Modifier.padding(vertical = 10.dp)
                            )
                        }

                    }
                    HorizontalDivider(Modifier.fillMaxWidth(), color = gray)
                    Text(
                        text = "Xem thêm sản phẩm", fontSize = 14.sp, color = gray,
                        modifier = Modifier.padding(vertical = 10.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    HorizontalDivider(Modifier.fillMaxWidth(), color = gray)

                    Row(Modifier.padding(horizontal = 8.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "Giao hàng thành công", fontSize = 14.sp, color = gray,
                            modifier = Modifier.padding(vertical = 10.dp)
                        )
                        Icon(painter = painterResource(R.drawable.right),
                            contentDescription = "",
                            tint = gray,
                            modifier = Modifier.size(38.dp)
                        )
                    }
                        HorizontalDivider(Modifier.fillMaxWidth(), color = gray)
                    Row(Modifier.padding(horizontal = 8.dp).weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Vui lòng đánh giá sản phẩm", fontSize = 14.sp, color = gray,
                            modifier = Modifier.padding(vertical = 10.dp).weight(1f)
                        )
                        Box(modifier = Modifier.weight(0.4f)) {
                            CustomButton(text = "Đánh giá", padding = 10.dp, cornerRadius = 8.dp, onClick =  {

                            })
                        }

                    }
                }
            })
        })
}
@Composable
fun CustomItemProfilee(iconResId: Int,title: String, subTitle: String, modifier: Modifier = Modifier,icon2 : Int) {
    // custom item food
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier
            .fillMaxWidth().padding(vertical = 10.dp)
            .height(110.dp),
        content = {
            customBox (content = {
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth().fillMaxHeight().padding(10.dp)
                ) {
                    Icon(painter = painterResource(iconResId),
                        contentDescription = "", tint = hintColor,
                        modifier = Modifier.size(48.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(
                        modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
                            .weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(text = title, fontSize = 20.sp, color = white, maxLines = 1)
                        Text(text = subTitle, fontSize = 16.sp, color = gray, maxLines = 1)
                    }
                    Icon(painter = painterResource(icon2),
                        contentDescription = "", tint = hintColor,
                        modifier = Modifier.size(55.dp))

                }
            })
        })
}
@Composable
fun customBox(height: Dp = 110.dp,content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth().height(height)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF262B33), // Màu #262B33
                        Color(0x00262B33)  // Màu #262B33 với độ trong suốt (alpha = 0)
                    ),
                    start = Offset(0f, 0f), // Điểm bắt đầu (góc độ tương đương 158.84deg)
                    end = Offset(1000f, 3000f) // Điểm kết thúc (góc lệch)
                ), shape = RoundedCornerShape(23.dp)
            )
    ) {
        content()
    }
}
@Composable
fun customBox2(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF262B33), // Màu #262B33
                        Color(0x00262B33)  // Màu #262B33 với độ trong suốt (alpha = 0)
                    ),
                    start = Offset(0f, 0f), // Điểm bắt đầu (góc độ tương đương 158.84deg)
                    end = Offset(1000f, 3000f) // Điểm kết thúc (góc lệch)
                ), shape = RoundedCornerShape(23.dp)
            )
    ) {
            content()
        }
    }

val product = Product(name = "Cơm rang sườn",
        price = 100000.0, image = R.drawable.comtam,
        rating = 4.9,
        description = "Cơm rang sườn với thịt nướng đặc biệt",
        isFavorite = false,
        categoryId = "CT1")

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    historyFood(product)
}