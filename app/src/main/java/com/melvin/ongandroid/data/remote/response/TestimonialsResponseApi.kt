package com.melvin.ongandroid.data.remote.response

import com.melvin.ongandroid.data.local.model.Testimonial

data class TestimonialsResponseApi (
    val success:Boolean = false,
    val data: List<Testimonial> = listOf(),
    val message: String = ""
)