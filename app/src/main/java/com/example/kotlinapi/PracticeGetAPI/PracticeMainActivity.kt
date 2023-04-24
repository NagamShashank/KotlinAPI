package com.example.kotlinapi.PracticeGetAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapi.NestedObjectsAPI.NestedDataClass
import com.example.kotlinapi.NestedObjectsAPI.Nested_Adapter
import com.example.kotlinapi.R
import com.example.kotlinapi.databinding.ActivityPracticeMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PracticeMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPracticeMainBinding

    private lateinit var adapter : Nested_Adapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.PracticeRecyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.PracticeRecyclerView.layoutManager = linearLayoutManager

        getPracticeData()

    }

    private fun getPracticeData() {


        PracticeRetrofitInstance.practiceRetrofitInstance.getNestData().enqueue(object : Callback<List<NestedDataClass>?> {
            override fun onResponse(
                call: Call<List<NestedDataClass>?>,
                response: Response<List<NestedDataClass>?>) {

                val responseBodyNest =  response.body()!!

                adapter = Nested_Adapter(baseContext,responseBodyNest)
                adapter.notifyDataSetChanged()
                binding.PracticeRecyclerView.adapter = adapter
            }
            override fun onFailure(call: Call<List<NestedDataClass>?>, t: Throwable) {}
        })
    }
}