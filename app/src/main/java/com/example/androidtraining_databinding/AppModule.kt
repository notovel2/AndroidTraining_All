package com.example.androidtraining_databinding

import org.koin.dsl.module

val  appModule = module {
    single { NetworkClient() }
    single { ApiService(get()) }
}