package com.melvin.ongandroid.model.apiservice

<<<<<<< HEAD
import com.melvin.ongandroid.data.apiservice.ApiConstants
=======
import com.melvin.ongandroid.constantsapi.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

>>>>>>> 242e7239aabdb1dd26c2e781d3c43ec6aa0de220
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