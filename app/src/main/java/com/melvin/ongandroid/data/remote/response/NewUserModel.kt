package com.melvin.ongandroid.data.remote.response

import com.google.gson.annotations.SerializedName

data class NewUserResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String
)