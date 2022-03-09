package com.melvin.ongandroid.data.login.repository

import com.melvin.ongandroid.data.login.LoginApiService

/**
 * Repositorio del login con una funcion suspendida que  retorna la llamada a la API
 * @author Jose Luis Mora
 */

class LoginRepository(private val api: LoginApiService): LoginBaseRepository() {

    suspend fun login (email:String?, password: String?) = safeApiCall {

        api.login(email, password)
    }
}