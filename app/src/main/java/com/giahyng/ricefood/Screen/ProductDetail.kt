package com.giahyng.ricefood.Screen

import android.os.Bundle
import android.widget.RatingBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.giahyng.ricefood.R
import com.giahyng.ricefood.ui.ButtonWithIcon
import com.giahyng.ricefood.ui.ButtonWithIconRadius
import com.giahyng.ricefood.ui.black
import com.giahyng.ricefood.ui.customBox
import com.giahyng.ricefood.ui.customBox2
import com.giahyng.ricefood.ui.gray
import com.giahyng.ricefood.ui.hintColor
import com.giahyng.ricefood.ui.itemsColor
import com.giahyng.ricefood.ui.plushAndminus
import com.giahyng.ricefood.ui.primaryColor
import com.giahyng.ricefood.ui.primaryColor2
import com.giahyng.ricefood.ui.textColorItems
import com.giahyng.ricefood.ui.textDescription
import com.giahyng.ricefood.ui.white

class ProductDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

@Composable
fun productDetail() {
    var quantity: Int = 1
    Column(Modifier.fillMaxSize().background(color = primaryColor)) {
        Box (){
            Image(
                painter = painterResource(id = R.drawable.comtam),
                modifier = Modifier.fillMaxWidth(),
                contentDescription = ""
            )

            Row(
                Modifier.offset(8.dp).height(180.dp).padding(15.dp, 10.dp, 25.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    Modifier.width(48.dp).height(48.dp).clip(shape = RoundedCornerShape(16.dp))
                        .background(itemsColor),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        modifier = Modifier.size(24.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .align(alignment = Alignment.Center),
                        contentDescription = "",
                        tint = hintColor
                    )
                }
                Box(
                    Modifier.width(48.dp).height(48.dp).clip(shape = RoundedCornerShape(16.dp))
                        .background(itemsColor),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.favorite),
                        modifier = Modifier.size(28.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .align(alignment = Alignment.Center),
                        contentDescription = ""
                    )
                }
            }

        }

        val rememberScrollState = rememberScrollState()
        Column(
            Modifier
                .weight(1f).padding(8.dp,0.dp)
                .fillMaxWidth()
        ) {
            customBox2(content = {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Cơm rang sườn",
                        fontSize = 26.sp,
                        color = white,
                        maxLines = 1,
                        fontWeight = FontWeight(700)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.baseline_star_24),
                            modifier = Modifier.size(32.dp), contentDescription = null
                        )
                        Row {
                            Text(
                                text = "5",
                                fontSize = 28.sp,
                                color = white, fontWeight = FontWeight(700),
                                modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)
                                    .align(alignment = Alignment.CenterVertically)
                            )
                            Text(
                                text = "(Xem ngay)",
                                fontSize = 14.sp,
                                color = white,
                                maxLines = 1,
                                modifier = Modifier.align(alignment = Alignment.CenterVertically)
                                    .padding(10.dp, 0.dp),
                                fontStyle = FontStyle.Italic
                            )

                        }

                    }
                    Spacer(Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "100.000 VND",
                            fontSize = 30.sp,
                            color = white,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold
                        )
                        Row {
                            plushAndminus(value = "+",
                                textcolor = white,
                                backgroundColor = primaryColor,
                                width = 40.dp,
                                onClick = {
                                    if (quantity < 20) {
                                        quantity++
                                    }
                                })
                            Text(
                                text = "${quantity}", fontSize = 28.sp, color = white,
                                modifier = Modifier.padding(8.dp, 0.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            plushAndminus(value = "-",
                                textcolor = black,
                                backgroundColor = textColorItems,
                                width = 40.dp,
                                onClick = {
                                    if (quantity > 1) {
                                        quantity--
                                    }
                                })
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Column(
                        Modifier
                            .weight(1f).padding(8.dp,0.dp)
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState)
                    ) {
                        Text(
                            text = "Cơm: Cơm tấm được làm từ gạo tấm, một loại gạo bị vỡ, thường được nấu mềm và dẻo.\n" +
                                    "Thịt: Món này thường đi kèm với các loại thịt như:\n" +
                                    "Sườn nướng: Thịt sườn được ướp gia vị và nướng trên than hồng, tạo ra hương vị thơm ngon.\n" +
                                    "Thịt bì: Là phần da heo thái mỏng, trộn với thính gạo và gia vị, mang lại độ giòn và béo.\n" +
                                    "Trứng ốp la: Trứng gà chiên với lòng đỏ chảy, thêm vào tạo sự hấp dẫn cho món ăn.\n" +
                                    "Rau sống: Bao gồm rau xà lách, dưa leo và các loại rau thơm như ngò rí, húng quế.",
                            fontSize = 20.sp,
                            color = white,
                        )
                    }
                }
            })
        }
            Column(
                modifier = Modifier.fillMaxWidth()
                    .height(70.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonWithIconRadius(iconResId = R.drawable.ic_cart,
                    value = "Thêm vào giỏ hàng",
                    onClick = {

                    }
                    , backgroundColor = textColorItems
                )
            }
    }
}
