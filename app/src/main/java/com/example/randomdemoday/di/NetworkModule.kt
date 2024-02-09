package com.example.randomdemoday.di

import com.example.randomdemoday.remote.service.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideApiService() }
}

private const val api = "https://geeksadmin.pythonanywhere.com/api/"

private fun provideApiService() =
    Retrofit.Builder()
        .baseUrl(api)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
