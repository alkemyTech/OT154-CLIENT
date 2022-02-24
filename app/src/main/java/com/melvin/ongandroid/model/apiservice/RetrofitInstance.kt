package com.melvin.ongandroid.model.apiservice

//import com.melvin.ongandroid.constantsapi.ApiConstants

import com.melvin.ongandroid.constantsapi.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client : OkHttpClient.Builder= OkHttpClient.Builder()
            .cache(null)
            .addInterceptor(interceptor)

        return client.build()

    }


    private fun getOkhttpClient(): OkHttpClient {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
            .cache(null)
            .addInterceptor(interceptor)

        return client.build()

    }

}
