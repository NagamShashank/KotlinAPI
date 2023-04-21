package com.example.kotlinapi.NestedObjectsAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapi.databinding.ItemLayout2Binding

class Nested_Adapter(val context:Context,val NewListUser: List<NestedDataClass>) : RecyclerView.Adapter<Nested_Adapter.MyNestView>() {

    class MyNestView(val itemLayout2Binding: ItemLayout2Binding):RecyclerView.ViewHolder(itemLayout2Binding.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Nested_Adapter.MyNestView {
        return MyNestView(ItemLayout2Binding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: Nested_Adapter.MyNestView, position: Int) {
        holder.itemLayout2Binding.ID.text = NewListUser[position].id.toString()
        holder.itemLayout2Binding.Name.text = NewListUser[position].name
        holder.itemLayout2Binding.Street.text = NewListUser[position].address?.street
        holder.itemLayout2Binding.CompanyName.text = NewListUser[position].company?.name
        holder.itemLayout2Binding.Latitude.text = NewListUser[position].address?.geo?.lat
        holder.itemLayout2Binding.Email.text = NewListUser[position].email
        holder.itemLayout2Binding.Phone.text = NewListUser[position].phone
        holder.itemLayout2Binding.Website.text = NewListUser[position].website
        holder.itemLayout2Binding.Longitude.text = NewListUser[position].address?.geo?.lng
    }

    override fun getItemCount(): Int {
      return NewListUser.size
    }


}