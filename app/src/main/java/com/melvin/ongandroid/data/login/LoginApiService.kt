package com.melvin.ongandroid.data.login

import com.melvin.ongandroid.model.login.LoginModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Interface que hace la llamada al end point de la API mediante el motodo POST y como un formulario
 * @author Jose Luis Mora
 */

interface LoginApiService {

    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): LoginModel

}