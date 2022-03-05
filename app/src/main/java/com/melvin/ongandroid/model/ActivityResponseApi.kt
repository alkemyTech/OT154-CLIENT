package com.melvin.ongandroid.model

class ActivityResponseApi (
    val success:Boolean = false,
    val data: List<Testimonial> = listOf(),
    val message: String = ""
)