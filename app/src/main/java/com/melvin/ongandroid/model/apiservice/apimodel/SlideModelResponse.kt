package com.melvin.ongandroid.model.apiservice.apimodel

import com.google.gson.annotations.SerializedName
import com.melvin.ongandroid.model.apimodel.ActivityModel

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