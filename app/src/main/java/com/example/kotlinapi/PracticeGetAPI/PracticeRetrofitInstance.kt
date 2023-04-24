package com.example.kotlinapi.PracticeGetAPI

import com.example.kotlinapi.NestedObjectsAPI.Nested_ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PracticeRetrofitInstance {

    val URL = "https://jsonplaceholder.typicode.com/"

    val practiceRetrofitInstance = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(URL)
        .build()
        .create(Nested_ApiInterface::class.java)
}