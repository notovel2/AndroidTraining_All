package com.example.androidtraining_databinding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContributorViewModelFactory(
    private val apiService: ApiService
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContributorViewModel(apiService) as T
    }
}