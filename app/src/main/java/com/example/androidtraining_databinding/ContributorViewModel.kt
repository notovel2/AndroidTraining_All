package com.example.androidtraining_databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContributorViewModel(
    private val apiService: ApiService
): ViewModel() {
    private var contributorLiveData: MutableLiveData<List<Contributor>> = MutableLiveData()

    fun searchContributors() {
        apiService.githubService
            .getContributors(
                "facebook",
                "react"
            )
            .enqueue(object: Callback<List<Contributor>> {
                override fun onFailure(call: Call<List<Contributor>>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<List<Contributor>>,
                    response: Response<List<Contributor>>
                ) {
                    contributorLiveData.value = response.body()
                }

            })
    }

    fun getContributors(): LiveData<List<Contributor>> {
        return contributorLiveData
    }
}