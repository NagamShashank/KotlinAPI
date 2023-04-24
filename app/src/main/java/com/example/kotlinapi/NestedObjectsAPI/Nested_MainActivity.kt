package com.example.kotlinapi.NestedObjectsAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapi.ApiInterface
import com.example.kotlinapi.BASE_URL
import com.example.kotlinapi.MyAdapter
import com.example.kotlinapi.R
import com.example.kotlinapi.databinding.ActivityNestedMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Nested_MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNestedMainBinding

    val BASE_URL_NEST = "https://jsonplaceholder.typicode.com/"

    private lateinit var adapter: Nested_Adapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNestedMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecyclerViewNested.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.RecyclerViewNested.layoutManager = linearLayoutManager

        getMyNestedData()

    }

    private fun getMyNestedData() {

        val retrofitBuilderNested = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_NEST)
            .build()
            .create(Nested_ApiInterface::class.java)

        val Nested_ApiInterface = retrofitBuilderNested.getNestData()

        Nested_ApiInterface.enqueue(object : Callback<List<NestedDataClass>?> {
            override fun onResponse(
                call: Call<List<NestedDataClass>?>, response: Response<List<NestedDataClass>?>) {
                val responseBodyNested =  response.body()!!
                adapter = Nested_Adapter(baseContext,responseBodyNested)
                adapter.notifyDataSetChanged()
                binding.RecyclerViewNested.adapter = adapter
            }
            override fun onFailure(call: Call<List<NestedDataClass>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}