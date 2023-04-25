package com.example.kotlinapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlinapi.databinding.ActivityPostBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL_SEND = "https://jsonplaceholder.typicode.com/"

class PostActivity : AppCompatActivity() {



    private lateinit var binding : ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sendMydata()

    }

    private fun sendMydata() {
        val retrofitSendBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_SEND)
            .build()
            .create(ApiInterface::class.java)

        binding.SendButton.setOnClickListener(View.OnClickListener {
            val ID = binding.EditTextID.text.toString()
            val UserID = binding.EditTextUserID.text.toString()
            val Title  = binding.EditTextBody.text.toString()
            val UserBody = binding.EditTextBody.text.toString()

            if((ID.isEmpty() && UserID.isEmpty())&&(Title.isEmpty()&&UserBody.isEmpty())){
                Toast.makeText(applicationContext,"Please Enter Whole Info",Toast.LENGTH_SHORT).show()
            }else{

                val newID = ID.toInt()
                val newUserID = UserID.toInt()
                val myData = MyData(newUserID,newID,Title,UserBody)
                val call =  retrofitSendBuilder.SendData(myData)

                call.enqueue(object:Callback<MyData>{
                    override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                        Toast.makeText(applicationContext,"Data Sended",Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<MyData>, t: Throwable) {
                        Toast.makeText(applicationContext,"Data Not Sended",Toast.LENGTH_SHORT).show()
                    }
                })
            }

        })

        binding.GetDataBtn.setOnClickListener(View.OnClickListener {
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        })

    }
}