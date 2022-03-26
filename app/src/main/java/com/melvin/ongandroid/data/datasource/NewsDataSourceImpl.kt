package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.remote.response.NewsResponse
import retrofit2.Response

class NewsDataSourceImpl: NewsDataSource {
    private val service = APIManager()
    override suspend fun getNews(): Response<NewsResponse> {
        return service.getNews()
    }
}