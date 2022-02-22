package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Testimonial

class APIManager {

    suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>> {
        return getRetrofitInstance().getTestimonials()
    }

    private fun getRetrofitInstance(): APIService {
        return Retrofit2.getRetrofit().create(APIService::class.java)
    }
}