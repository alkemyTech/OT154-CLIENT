package com.melvin.ongandroid.data.local.model

/**
 * Data class que representa una novedad de lista News
 * recuperado desde el backend o api
 *
 * @author Martin Re
 */
import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("category_id")
    var categoryId: Any?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("deleted_at")
    var deletedAt: Any?,
    @SerializedName("group_id")
    var groupId: Any?,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("slug")
    var slug: Any?,
    @SerializedName("updated_at")
    var updatedAt: String,
    @SerializedName("user_id")
    var userId: Any?
) {
}