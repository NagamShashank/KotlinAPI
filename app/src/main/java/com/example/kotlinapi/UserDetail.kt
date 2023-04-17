package com.example.kotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapi.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {

    private lateinit var binding : ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val D_Id =intent.getStringExtra("UserID")
        val D_Title = intent.getStringExtra("Title")
        val D_Body = intent.getStringExtra("Body")

        binding.DetailsUserId.text = D_Id
        binding.DetailsTitle.text = D_Title
        binding.DetailsBody.text = D_Body

    }
}