package com.melvin.ongandroid.model.apiservice.apimodel

/**
 * Data class que representa un response a consulta backend/api
 *
 * @author Martin Re
 */
import com.google.gson.annotations.SerializedName
import com.melvin.ongandroid.model.apimodel.NewsModel

class NewsResponse(@SerializedName("data")
                        var data: List<NewsModel>,
                   @SerializedName("message")
                        var message: String,
                   @SerializedName("success")
                        var success: Boolean) {
}