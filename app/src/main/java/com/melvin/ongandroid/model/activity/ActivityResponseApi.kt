package com.melvin.ongandroid.model.activity

import com.melvin.ongandroid.model.Testimonial

class ActivityResponseApi (
    val success:Boolean = false,
    val data: List<Activity> = listOf(),
    val message: String = ""
)