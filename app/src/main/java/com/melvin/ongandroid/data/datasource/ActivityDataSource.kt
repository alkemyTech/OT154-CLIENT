package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.activity.Activity

interface ActivityDataSource {
   suspend fun getActivities(): ResponseApi<MutableList<Activity>>
}