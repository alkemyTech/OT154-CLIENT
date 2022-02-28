package com.melvin.ongandroid.model

data class TestimonialsResponseApi (
    val success:Boolean = false,
    val data: List<Testimonial> = listOf(),
    val message: String = ""
)