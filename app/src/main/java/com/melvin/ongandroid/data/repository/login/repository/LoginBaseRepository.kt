package com.melvin.ongandroid.data.repository.login.repository

import com.melvin.ongandroid.data.repository.login.ResourceLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * Clase abstractab que representa la base para la creacion del repositorio. Utiliza corrutinas para
 * realizar la llamada a la API y retornar un ResourceLogin de tipo si la llamada es exitosa
 * @author Jose Luis Mora
 */

abstract class LoginBaseRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResourceLogin<T>
    {
        return withContext(Dispatchers.IO){
            try{
                ResourceLogin.Success(apiCall.invoke())
            }catch (throwable: Throwable){
                when(throwable){
                    is HttpException -> ResourceLogin.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    else -> ResourceLogin.Failure(true, null, null)
                }
            }
        }

    }
}