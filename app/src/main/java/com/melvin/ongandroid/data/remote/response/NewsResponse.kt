package com.melvin.ongandroid.data.remote.response

/**
 * Data class que representa un response a consulta backend/api
 *
 * @author Martin Re
 */
import com.google.gson.annotations.SerializedName
import com.melvin.ongandroid.data.local.model.NewsModel

class NewsResponse(@SerializedName("data")
                        var data: List<NewsModel>,
                   @SerializedName("message")
                        var message: String,
                   @SerializedName("success")
                        var success: Boolean) {
}