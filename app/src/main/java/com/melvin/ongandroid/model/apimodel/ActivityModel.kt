package com.melvin.ongandroid.model.apimodel

import com.google.gson.annotations.SerializedName

/**
 * Data class que representa una Actividad de Slides
 * recuperado desde el backend o api
 *
 * @author Martin Re
 */
data class ActivityModel(
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("deleted_at")
    var deletedAt: Any?,
    @SerializedName("description")
    var description: String,
    @SerializedName("group_id")
    var groupId: Int?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("order")
    var order: Int,
    @SerializedName("updated_at")
    var updatedAt: String,
    @SerializedName("user_id")
    var userId: Any?
)