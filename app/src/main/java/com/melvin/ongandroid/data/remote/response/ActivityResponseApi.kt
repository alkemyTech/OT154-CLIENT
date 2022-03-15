package com.melvin.ongandroid.data.remote.response

import com.melvin.ongandroid.data.local.model.Activity

class ActivityResponseApi (
    val success:Boolean = false,
    val data: List<Activity> = listOf(),
    val message: String = ""
)