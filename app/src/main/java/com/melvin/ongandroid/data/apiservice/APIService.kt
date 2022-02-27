package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Testimonial
import retrofit2.http.GET

interface APIService {
    @GET( "api/testimonials")
    suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>>
}