package com.melvin.ongandroid.data.login.repository

import com.melvin.ongandroid.data.login.ResourceLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

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