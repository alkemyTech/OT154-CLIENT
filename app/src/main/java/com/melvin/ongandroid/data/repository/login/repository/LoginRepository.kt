package com.melvin.ongandroid.data.repository.login.repository

import com.melvin.ongandroid.data.remote.network.APIService

/**
 * Repositorio del login con una funcion suspendida que  retorna la llamada a la API
 * @author Jose Luis Mora
 */

class LoginRepository(private val api: APIService): LoginBaseRepository() {

    suspend fun login (email:String?, password: String?) = safeApiCall {

        api.login(email, password)
    }
}