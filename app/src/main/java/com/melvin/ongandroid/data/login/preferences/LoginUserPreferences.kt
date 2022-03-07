package com.melvin.ongandroid.data.login.preferences

import android.content.Context

class LoginUserPreferences(val context: Context) {
    private val SHARED_NAME = "myDataBase"
    private val SHARED_USER_TOKEN = "usertoken"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    suspend fun saveTokenUser(token:String){
        storage.edit().putString(SHARED_USER_TOKEN, token).apply()
    }

    fun getTokenUser():String = storage.getString(SHARED_USER_TOKEN,"")!!
}