package com.melvin.ongandroid.data.login.repository

import com.melvin.ongandroid.data.login.LoginApiService

class LoginRepository(private val api: LoginApiService): LoginBaseRepository() {

    suspend fun login (email:String?, password: String?) = safeApiCall {

        api.login(email, password)
    }
}