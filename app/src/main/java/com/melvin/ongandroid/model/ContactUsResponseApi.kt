package com.melvin.ongandroid.model

data class ContactUsResponseApi (
    val success:Boolean = false ,
    val data: List<Testimonial> = listOf(),
    val message: String = ""
    )
