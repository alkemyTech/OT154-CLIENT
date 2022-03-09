package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2 {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        /**
         * Funcion que devuelve un objeto retrofit con cliente okhttp
         * @author Jose Luis Mora
         */

        fun<Api> buildApi( api: Class<Api>): Api
        {
            return Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(
                    OkHttpClient.Builder().also {client ->
                        if(BuildConfig.DEBUG){
                            val logging = HttpLoggingInterceptor()
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                            client.addInterceptor(logging)
                        }
                    }.build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)

        }

    }

}