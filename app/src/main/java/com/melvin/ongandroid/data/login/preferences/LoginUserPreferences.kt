package com.melvin.ongandroid.data.login.preferences

import android.content.Context

/**
 * Clase que representa las preferencias del usuario, se crea la preferencia para que se guarde el token devuelto
 * por la API
 * @author Jose Luis Mora
 */

class LoginUserPreferences(val context: Context) {
    private val SHARED_NAME = "myDataBase"
    private val SHARED_USER_TOKEN = "usertoken"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    suspend fun saveTokenUser(token:String){
        storage.edit().putString(SHARED_USER_TOKEN, token).apply()
    }

    fun getTokenUser():String = storage.getString(SHARED_USER_TOKEN,"")!!
}