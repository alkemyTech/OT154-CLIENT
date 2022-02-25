package com.melvin.ongandroid.model.apiservice


import com.melvin.ongandroid.constantsapi.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        fun retrofitBuilder(url: String = ApiConstants.BASE_URL) = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}