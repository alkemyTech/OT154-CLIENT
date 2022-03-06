package com.melvin.ongandroid.data.login

import okhttp3.ResponseBody

sealed class ResourceLogin<out T>{

    data class Success<out T>(val value: T): ResourceLogin<T>()
    data class Failure(val isNetworkError: Boolean, val erroCode: Int?, val errorBody: ResponseBody?): ResourceLogin<Nothing>()
}