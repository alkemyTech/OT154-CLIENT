package com.melvin.ongandroid.model.login

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("data") val data: Data,
    val message: String,
    val success: Boolean
)