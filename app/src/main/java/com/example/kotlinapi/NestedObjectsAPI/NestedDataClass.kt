package com.example.kotlinapi.NestedObjectsAPI

import com.google.gson.annotations.SerializedName

data class NestedDataClass(
    val id : Int,
    val name: String,
    val username : String,
    val email: String,
    val phone: String,
    val website: String,

    @SerializedName("address") val address: Address? = null,

    @SerializedName("company") val company: Company? = null

)