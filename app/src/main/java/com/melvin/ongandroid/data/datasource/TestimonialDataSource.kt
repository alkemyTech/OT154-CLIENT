package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.model.Testimonial
import com.melvin.ongandroid.data.response.ResponseApi

interface TestimonialDataSource {
   suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>>
}