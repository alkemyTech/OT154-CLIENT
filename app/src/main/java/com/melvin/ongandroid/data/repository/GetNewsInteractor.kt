package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.NewsModel


class GetNewsInteractor {

    private val repository = NewsRepositoryImpl()

    suspend operator fun invoke(): List<NewsModel> {
        val listActivities = repository.getAllNewsFromApi()
        return if (listActivities.isNullOrEmpty()){
            emptyList()
        }else{
            listActivities
        }
    }
}