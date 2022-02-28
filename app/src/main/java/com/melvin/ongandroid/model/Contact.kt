package com.melvin.ongandroid.model

import com.google.gson.annotations.SerializedName

class Contact(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("message") val message: String
)