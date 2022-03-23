package com.melvin.ongandroid.data.local.model

import com.google.gson.annotations.SerializedName

data class MembersModel(
    @SerializedName("id") val id: Int= 0,
    @SerializedName("name") val name: String,
    @SerializedName("image")val image: String,
    @SerializedName("description") val description: String,
    @SerializedName("facebookUrl") val facebookUrl: String,
    @SerializedName("linkedinUrl") val linkedinUrl: String,
)
