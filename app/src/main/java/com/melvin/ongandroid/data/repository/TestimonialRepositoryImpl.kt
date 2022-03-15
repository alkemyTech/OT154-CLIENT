package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.datasource.TestimonialDataSource
import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.remote.response.ResponseApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestimonialRepositoryImpl(private val dataSource: TestimonialDataSource) :
    TestimonialRepository {
    override fun getTestimonials(): Flow<Response<ResponseApi<MutableList<Testimonial>>>> = flow {
        try {
            val apiResponse = dataSource.getTestimonials()
            emit(Response.Success(apiResponse))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}