package com.melvin.ongandroid.model.login


/**
 * Modelo que representa el array json llamado user
 * @author Jose Luis Mora
 */

data class User(
    val address: Any,
    val created_at: String,
    val deleted_at: Any,
    val email: String,
    val email_verified_at: Any,
    val group_id: Any,
    val id: Int,
    val latitude: Any,
    val longitude: Any,
    val name: String,
    val password: String,
    val profile_image: Any,
    val remember_token: Any,
    val role_id: Int,
    val updated_at: String
)