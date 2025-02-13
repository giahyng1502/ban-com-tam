package com.giahyng.ricefood

import android.util.Log
import androidx.compose.runtime.Composable
import com.giahyng.ricefood.model.Favourite
import com.giahyng.ricefood.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val retrofitService = RetrofitService()
val apiService = retrofitService.createService(ApiService::class.java)
fun login(email: String, password: String, onSuccess: (LoginResponse) -> Unit, onFailure: () -> Unit) {
    val call = apiService.login(LoginRequest(email = email, password = password))
    call.enqueue(object : Callback<LoginResponse> {
        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            if (response.isSuccessful) {
                response.body()?.let { loginResponse ->
                    onSuccess(loginResponse)  // Gọi callback thành công với đối tượng LoginResponse
                } ?: onFailure() // Nếu body null, gọi onFailure
            } else {
                onFailure() // Nếu không thành công
            }
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            // Xử lý lỗi kết nối
            onFailure() // Gọi callback lỗi
            Log.d("hungcy", "Error: ${t.message}")  // In ra l��i xảy ra
        }
    })
}

//fun ApiFavourite(id : String,token : String) : Favourite{
//    val apiWithToken = RetrofitServiceWithToken(token).createService(ApiService::class.java)
//    apiWithToken.addToFavourite(id).enqueue(object : Callback<FavouriteRes>{
//        override fun onResponse(p0: Call<FavouriteRes>, res: Response<FavouriteRes>) {
//            if(res.isSuccessful){
//
//            }else{
//                Log.d("hungcy","add to favourite failed")
//            }
//        }
//
//        override fun onFailure(p0: Call<FavouriteRes>, p1: Throwable) {
//            Log.d("hungcy", "onFailure: "+p1.message)
//        }
//    })
//}


