package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.remote.response.SlideModelResponse
import retrofit2.Response

class SlideDataSourceImpl: SlideDataSource {
    private val service = APIManager()
    override suspend fun getSlides(): Response<SlideModelResponse> {
        return service.getSlides()
    }
}