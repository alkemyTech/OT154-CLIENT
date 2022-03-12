package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.datasource.ActivityDataSource
import com.melvin.ongandroid.data.datasource.TestimonialDataSource
import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.model.Testimonial
import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.activity.Activity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ActivityRepositoryImpl(private val dataSource: ActivityDataSource) :
    ActivityRepository {
    override fun getActivities(): Flow<Response<ResponseApi<MutableList<Activity>>>> = flow {
        try {
            val apiResponse = dataSource.getActivities()
            emit(Response.Success(apiResponse))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}