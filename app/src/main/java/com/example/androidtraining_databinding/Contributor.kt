package com.example.androidtraining_databinding

import com.google.gson.annotations.SerializedName

class Contributor(
    @SerializedName("login")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("avatar_url")
    val imageURL: String)