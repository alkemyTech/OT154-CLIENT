package com.melvin.ongandroid.data.local.model

import com.google.gson.annotations.SerializedName

data class Testimonial(
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("image") val image:String,
    @SerializedName("description") val description:String
){
    val descriptionQuotationMarks : String
    get() = "\"$description\""

}