package com.melvin.ongandroid.data.repository.login

import okhttp3.ResponseBody

/**
 * Clase que contiene el resultado de la llamada a la API, si es Success retorne un ResourceLogin de cualquier tipo.
 * Si es Failure, arroja un error y no revuelve nada
 * @author Jose Luis Mora
 */

sealed class ResourceLogin<out T>{

    data class Success<out T>(val value: T): ResourceLogin<T>()
    data class Failure(val isNetworkError: Boolean, val erroCode: Int?, val errorBody: ResponseBody?): ResourceLogin<Nothing>()
}