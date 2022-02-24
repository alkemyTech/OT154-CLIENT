package com.melvin.ongandroid.model.apiservice

import com.google.gson.annotations.SerializedName

data class ResponseApi<T>(
    @SerializedName("success") var succes: Boolean,
    @SerializedName("data") var data: T,
    @SerializedName("message") var message: String
)