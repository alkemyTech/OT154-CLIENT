package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.remote.response.ResponseApi
import kotlinx.coroutines.flow.Flow

interface TestimonialRepository {
    fun getTestimonials(): Flow<Response<ResponseApi<MutableList<Testimonial>>>>
}