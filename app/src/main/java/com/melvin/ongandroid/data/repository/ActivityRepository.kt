package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Activity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    fun getActivities(): Flow<Response<ResponseApi<MutableList<Activity>>>>
}