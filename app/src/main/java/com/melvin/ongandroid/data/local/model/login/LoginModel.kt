package com.melvin.ongandroid.data.local.model.login

import com.google.gson.annotations.SerializedName

/**
 * Model principal de la respuesta cuando se realiza una peticion a una API
 * @author Jose Luis Mora
 */

data class LoginModel(
    @SerializedName("data") val data: Data,
    val message: String,
    val success: Boolean
)