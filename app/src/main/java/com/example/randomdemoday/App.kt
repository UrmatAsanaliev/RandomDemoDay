package com.example.randomdemoday

import android.app.Application
import com.example.randomdemoday.di.networkModule
import com.example.randomdemoday.di.repoModule
import com.example.randomdemoday.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(networkModule, repoModule, viewModule)
        }
    }
}