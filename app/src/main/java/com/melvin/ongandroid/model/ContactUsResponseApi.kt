package com.melvin.ongandroid.model

data class ContactUsResponseApi (
    val success:Boolean = false ,
    val data: List<Contact> = listOf(),
    val message: String = ""
    )
