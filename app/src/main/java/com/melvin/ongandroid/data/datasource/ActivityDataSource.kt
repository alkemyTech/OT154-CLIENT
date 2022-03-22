package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Activity

interface ActivityDataSource {
   suspend fun getActivities(): ResponseApi<MutableList<Activity>>
}