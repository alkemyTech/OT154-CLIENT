package com.melvin.ongandroid.model

import com.google.gson.annotations.SerializedName

data class Activity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("user_id") val user_id: Int,
    @SerializedName("category_id") val category_id: Int
) {
    val descriptionQuotationMarks: String
        get() = "\"$description\""
}