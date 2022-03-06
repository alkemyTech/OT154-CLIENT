package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.activity.Activity

class APIActivityManager {

    suspend fun getActivities(): ResponseApi<MutableList<Activity>> {
        return getRetrofitInstance().getActivities()
    }

    private fun getRetrofitInstance(): APIService {
        return Retrofit2.getRetrofit().create(APIService::class.java)
    }
}