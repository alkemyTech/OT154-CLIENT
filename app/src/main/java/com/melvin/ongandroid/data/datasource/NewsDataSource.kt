package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.local.model.NewsModel
import com.melvin.ongandroid.data.remote.response.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNews(): Response<NewsResponse>
}