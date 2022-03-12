package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.activity.Activity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    fun getActivities(): Flow<Response<ResponseApi<MutableList<Activity>>>>
}