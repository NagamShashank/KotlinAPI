package com.example.kotlinapi.PracticePostAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlinapi.MyData
import com.example.kotlinapi.R
import com.example.kotlinapi.databinding.ActivityPracticeMain2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PracticeMainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityPracticeMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sendMyPracticeData()

    }

    private fun sendMyPracticeData() {


        binding.SendPBtn.setOnClickListener(View.OnClickListener {

            val P_UserID = binding.PracticeUserID.text.toString()
            val P_ID = binding.PracticeID.text.toString()
            val P_Title = binding.PracticeTitle.text.toString()
            val P_Body = binding.PracticeBody.text.toString()


            if( (P_ID.isEmpty() && P_UserID.isEmpty() ) && (P_Title.isEmpty() && P_Body.isEmpty() ) )
            {
                Toast.makeText(applicationContext,"Please Enter The Data",Toast.LENGTH_SHORT).show()
            }else{

                val NewP_ID = P_ID.toInt()
                val NewP_UserID = P_UserID.toInt()
                val myData = MyData(NewP_UserID,NewP_ID,P_Title,P_Body)

                val postCall = PracticePostRetrofitInstance.practicePostRetrofitInstance.SendData(myData)

                postCall.enqueue(object : Callback<MyData?> {
                    override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                        Toast.makeText(applicationContext,"Data Sent Successfully",Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<MyData?>, t: Throwable) {
                        Toast.makeText(applicationContext,"Failed To Send Data",Toast.LENGTH_SHORT).show()
                    }
                })

            }
        })
    }
}