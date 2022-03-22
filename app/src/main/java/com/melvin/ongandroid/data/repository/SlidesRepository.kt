package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.ActivityModel

interface SlidesRepository {
    suspend fun getActivitiesFromApi(): List<ActivityModel>?
}