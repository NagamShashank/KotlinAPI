package com.example.kotlinapi.NestedObjectsAPI

import retrofit2.Call
import retrofit2.http.GET

interface Nested_ApiInterface {

    @GET("users")
    fun getNestData(): Call<List<NestedDataClass>>

}