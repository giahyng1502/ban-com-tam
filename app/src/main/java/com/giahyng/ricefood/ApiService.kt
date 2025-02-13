package com.giahyng.ricefood

import com.giahyng.ricefood.model.Cart
import com.giahyng.ricefood.model.Category
import com.giahyng.ricefood.model.Favourite
import com.giahyng.ricefood.model.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

data class LoginRequest(val email: String, val password: String)

data class LoginResponse(val token: String,val name: String)
data class FavouriteRes(val isFavourite: Boolean,val message : String)
data class Message(val message : String)
data class Quantity(val quantity: Int)
data class RegisterRequest(val name: String, val email: String, val password: String)
interface ApiService {
    @POST("users/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
    @POST("users/register")
    fun register(@Body registerRequest: RegisterRequest): Call<Message>
    @GET("product") // Thay thế bằng endpoint thực tế của bạn
    fun getData(): Call<List<Product>> // Khai báo dữ liệu trả về của API

    @GET("category")
    fun getCategory(): Call<List<Category>>

    @GET("favourite")
    fun getFavourite(): Call<List<Product>>

    @GET ("product/{id}")
    fun getProductDetail(@Path("id") id: String): Call<Product>

    @PUT("favourite/addFavourite/{id}")
    fun addToFavourite(@Path("id")id: String): Call<FavouriteRes>
    @GET("favourite/{id}")
    fun checkFavourite(@Path("id") id: String): Call<FavouriteRes>

    @POST("cart/addToCart/{id}")
    fun addToCart(@Path("id") id: String): Call<Message>

    @GET("cart/user")
    fun getCart(): Call<List<Cart>>
    @PUT("cart/{id}")
    fun updateCart(@Path("id") id: String, @Body quantity: Quantity): Call<Message>
}
