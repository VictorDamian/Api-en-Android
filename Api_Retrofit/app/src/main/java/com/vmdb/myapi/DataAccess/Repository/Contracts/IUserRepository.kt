package com.vmdb.myapi.DataAccess.Repository.Contracts

import com.vmdb.myapi.DataAccess.Repository.Models.User
import com.vmdb.myapi.DataAccess.Repository.Models.UserList
import com.vmdb.myapi.DataAccess.Repository.Models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface IUserRepository {
    @GET("users")
    @Headers("Accept:application/json",
        "Content-Type:application/json")
    fun GetAllUsers(): Call<UserList>

    @GET("users")
    @Headers("Accept:application/json",
        "Content-Type:application/json")
    fun GetUserName(@Query("name") searchName: String): Call<UserList>

    @GET("users{user_id}")
    @Headers("Accept:application/json",
        "Content-Type:application/json")
    fun GetUserId(@Query("user_id") searchId: String): Call<UserList>

    @POST("users")
    @Headers("Accept:application/json",
        "Content-Type:application/json","TOKEN")
    fun AddUser(@Body param: User): Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json",
        "Content-Type:application/json",
        "TOKEN")
    fun EditUser(@Path("user_id") editUser: String, @Body param: User): Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers("Accept:application/json",
        "Content-Type:application/json",
        "TOKEN")
    fun RemoveUser(@Path("user_id") editUser: String, @Body param: User): Call<UserResponse>
}