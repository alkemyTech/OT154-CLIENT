package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.apiservice.APIActivityManager
import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.activity.Activity

class ActivityDataSourceImpl(private val service: APIActivityManager): ActivityDataSource {
    override suspend fun getActivities(): ResponseApi<MutableList<Activity>> {
        return service.getActivities()
    }
}
