package com.melvin.ongandroid.model

import com.melvin.ongandroid.data.local.model.Contact

data class ContactUsResponseApi (
    val success:Boolean = false,
    val data: List<Contact> = listOf(),
    val message: String = ""
    )
