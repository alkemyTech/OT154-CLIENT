package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.remote.response.ResponseApi

class TestimonialDataSourceImpl(private val service: APIManager): TestimonialDataSource {
    override suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>> {
        return service.getTestimonials()
    }
}
