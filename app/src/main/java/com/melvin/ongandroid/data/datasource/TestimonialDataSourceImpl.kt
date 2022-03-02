package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.apiservice.APITestimonialManager
import com.melvin.ongandroid.model.Testimonial
import com.melvin.ongandroid.data.response.ResponseApi

class TestimonialDataSourceImpl(private val service: APITestimonialManager): TestimonialDataSource {
    override suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>> {
        return service.getTestimonials()
    }
}
