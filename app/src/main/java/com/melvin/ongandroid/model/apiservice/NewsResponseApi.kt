package com.melvin.ongandroid.model.apiservice


data class NewsResponseApi (
    val success:Boolean = false,
    val data: List<NewsResponse> = listOf(),
    val message: String = ""
)