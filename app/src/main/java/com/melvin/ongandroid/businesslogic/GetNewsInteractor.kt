package com.melvin.ongandroid.businesslogic

import com.melvin.ongandroid.model.apimodel.NewsModel
import com.melvin.ongandroid.model.apiservice.repository.NewsRepository


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