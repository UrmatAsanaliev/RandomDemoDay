package com.example.randomdemoday.di

import com.example.randomdemoday.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val viewModule = module {
        viewModel { MainViewModel(get()) }
    }
