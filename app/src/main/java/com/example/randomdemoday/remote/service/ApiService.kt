package com.example.randomdemoday.remote.service

import com.example.randomdemoday.remote.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users/")
    fun getUsers(): Call<MainResponse>
}