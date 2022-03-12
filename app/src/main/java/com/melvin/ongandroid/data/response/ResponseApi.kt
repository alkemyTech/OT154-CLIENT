package com.melvin.ongandroid.data.response

import com.google.gson.annotations.SerializedName

/*
Clase generica para ser utilizada en la interface APIService - Valderas Leandro
 */
data class ResponseApi<T>(
    @SerializedName("success") var succes: Boolean,
    @SerializedName("data") var data: T,
    @SerializedName("message") var message: String
)