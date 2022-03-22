package com.melvin.ongandroid.data.local.model

import com.google.gson.annotations.SerializedName

data class Activity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String?,
    @SerializedName("created_at") val created: String

) {
    val descriptionQuotationMarks: String
        get() = "\"$description\""
}