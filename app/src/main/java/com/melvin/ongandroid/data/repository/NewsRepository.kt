package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.NewsModel

interface NewsRepository {
    suspend fun getAllNewsFromApi(): List<NewsModel>?
}