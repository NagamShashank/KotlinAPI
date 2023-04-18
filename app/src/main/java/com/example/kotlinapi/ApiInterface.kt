package com.example.kotlinapi

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("posts")
    fun getData(): Call<List<MyData>>

    @POST("posts")
    fun SendData(
        @Body myData: MyData
    ):Call<MyData>

}