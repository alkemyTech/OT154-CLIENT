package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.datasource.ActivityDataSource
import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Activity
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