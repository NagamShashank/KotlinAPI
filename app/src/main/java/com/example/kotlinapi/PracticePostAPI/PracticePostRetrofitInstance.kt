package com.example.kotlinapi.PracticePostAPI

import com.example.kotlinapi.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PracticePostRetrofitInstance {

    val Post_URL = "https://jsonplaceholder.typicode.com/"

    val practicePostRetrofitInstance = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Post_URL)
        .build()
        .create(ApiInterface::class.java)


}