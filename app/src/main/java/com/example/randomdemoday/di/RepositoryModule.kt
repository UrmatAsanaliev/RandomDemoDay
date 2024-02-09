package com.example.randomdemoday.di

import com.example.randomdemoday.remote.repository.UserRepository
import org.koin.dsl.module

val repoModule = module {
    factory { UserRepository(get()) }
}