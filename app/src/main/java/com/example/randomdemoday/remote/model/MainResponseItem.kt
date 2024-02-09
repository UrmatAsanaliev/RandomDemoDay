package com.example.randomdemoday.remote.model

import com.google.gson.annotations.SerializedName

data class MainResponseItem(
    val id: Int,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_image")
    val image: String,
    @SerializedName("user_name")
    val name: String,
    @SerializedName("user_level")
    val target: String
)