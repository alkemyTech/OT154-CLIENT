package com.melvin.ongandroid.data.datasource


import com.melvin.ongandroid.data.remote.response.SlideModelResponse
import retrofit2.Response

interface SlideDataSource {
    suspend fun getSlides(): Response<SlideModelResponse>
}