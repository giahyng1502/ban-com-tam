import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.giahyng.ricefood.R
import com.giahyng.ricefood.ui.theme.Black
import com.giahyng.ricefood.ui.theme.bottomBarColor

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Map,
        BottomNavItem.Cart,
        BottomNavItem.Favorites,
        BottomNavItem.Notifications
    )

    BottomNavigation(
        backgroundColor = bottomBarColor,
        contentColor = Black
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon), // Sử dụng đúng thuộc tính 'icon'
                        contentDescription = null // Thêm contentDescription để hỗ trợ truy cập
                    )
                },
                selected = false, // Thêm điều kiện chọn
                onClick = {
                    // Xử lý sự kiện onClick để điều hướng hoặc cập nhật trạng thái
                    navController.navigate(item.route)
                }
            )
        }
    }
}

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object Home : BottomNavItem("Trang chủ", R.drawable.icon_home, "home")
    object Map : BottomNavItem("Vị trí", R.drawable.icon_map, "map")
    object Cart : BottomNavItem("Giỏ hàng", R.drawable.icon_cart, "cart")
    object Favorites : BottomNavItem("Yêu thích", R.drawable.icon_favorite, "favorite")
    object Notifications : BottomNavItem("Thông báo", R.drawable.icon_notification, "notifications")
}
