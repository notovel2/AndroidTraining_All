package com.example.androidtraining_databinding

import retrofit2.Retrofit
import retrofit2.create

class ApiService(
    private val retrofit: Retrofit
) {
    val githubService: GithubService
    init {
        githubService = retrofit.create()
    }
}