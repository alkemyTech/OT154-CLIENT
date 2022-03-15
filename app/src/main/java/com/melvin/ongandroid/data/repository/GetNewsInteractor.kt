package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.NewsModel


class GetNewsInteractor {

    private val repository = NewsRepository()

    suspend operator fun invoke(): List<NewsModel> {
        val listActivities = repository.getAllNewsFromApi()
        if (listActivities.isNullOrEmpty()){
            return emptyList()
        }else{
            return listActivities
        }
    }
}