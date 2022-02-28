package com.melvin.ongandroid.model.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import retrofit2.Response
import retrofit2.http.GET

interface NewsServiceApi {
    @GET("/api/news")
    suspend fun getNews(): Response<ResponseApi<List<NewsResponse>>>
}