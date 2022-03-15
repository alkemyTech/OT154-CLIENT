package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.remote.response.ResponseApi

interface TestimonialDataSource {
   suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>>
}