package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Activity
import retrofit2.http.GET

interface APIActivityService {
    @GET( "api/activity")
    suspend fun getActivities(): ResponseApi<MutableList<Activity>>
}