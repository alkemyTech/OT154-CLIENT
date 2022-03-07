package com.melvin.ongandroid.data.login

import com.melvin.ongandroid.model.login.LoginModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApiService {

    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): LoginModel

}