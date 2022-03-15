package com.melvin.ongandroid.data.remote.response

import com.google.gson.annotations.SerializedName
import com.melvin.ongandroid.data.local.model.ActivityModel

/**
 * Data class que representa un response a consulta backend/api
 *
 * @author Martin Re
 */
data class SlideModelResponse(
    @SerializedName("data")
    var data: List<ActivityModel>,
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Boolean
)