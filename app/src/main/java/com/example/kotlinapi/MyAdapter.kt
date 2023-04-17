package com.example.kotlinapi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapi.databinding.ItemLayoutBinding

class MyAdapter(val context:Context,val userList:List<MyData>):RecyclerView.Adapter<MyAdapter.MyView>() {
    inner class MyView(val itemLayoutBinding: ItemLayoutBinding):RecyclerView.ViewHolder(itemLayoutBinding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemLayoutBinding.UserId.text = userList[position].id.toString()
        holder.itemLayoutBinding.Title.text = userList[position].title
        holder.itemLayoutBinding.Body.text = userList[position].body

        holder.itemView.setOnClickListener(View.OnClickListener {

            val context = holder.itemView.context
            val stringID = userList[position].id.toString()
            val stringTitle = userList[position].title
            val stringBody = userList[position].body

            val intent = Intent(context,UserDetail::class.java)
            intent.putExtra("UserID",stringID)
            intent.putExtra("Title",stringTitle)
            intent.putExtra("Body",stringBody)

            context.startActivity(intent)

        })

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}