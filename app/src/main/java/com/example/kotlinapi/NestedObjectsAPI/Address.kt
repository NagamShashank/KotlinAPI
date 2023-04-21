package com.example.kotlinapi.NestedObjectsAPI

import com.google.gson.annotations.SerializedName

data class Address(
    val street : String,
    val suite : String,
    val city : String,
    val zipcode: String,

    @SerializedName("geo") val geo: Geo

    )
