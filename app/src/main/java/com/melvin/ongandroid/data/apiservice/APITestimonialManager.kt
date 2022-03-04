package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Testimonial

class APITestimonialManager {

    suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>> {
        return getRetrofitInstance().getTestimonials()
    }

    private fun getRetrofitInstance(): APITestimonialService {
        return Retrofit2.getRetrofit().create(APITestimonialService::class.java)
    }
}