package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Activity

class ActivityDataSourceImpl(private val service: APIManager): ActivityDataSource {
    override suspend fun getActivities(): ResponseApi<MutableList<Activity>> {
        return service.getActivities()
    }
}
