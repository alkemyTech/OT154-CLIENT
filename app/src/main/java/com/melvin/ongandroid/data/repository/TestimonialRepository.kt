package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.model.Testimonial
import com.melvin.ongandroid.data.response.ResponseApi
import kotlinx.coroutines.flow.Flow

interface TestimonialRepository {
    fun getTestimonials(): Flow<Response<ResponseApi<MutableList<Testimonial>>>>
}