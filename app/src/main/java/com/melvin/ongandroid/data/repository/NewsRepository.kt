package com.melvin.ongandroid.data.repository

/**
 * Esta clase obtiene un response de las novedades de la ONG.
 * Ya sea desde un repositorio remoto o local
 *
 * @author Martin Re
 */
import com.melvin.ongandroid.data.local.model.NewsModel
import com.melvin.ongandroid.data.remote.network.NewsModelService

open class NewsRepository {

    private val apiService = NewsModelService()

    open suspend fun getAllNewsFromApi(): List<NewsModel>? {
        val response = apiService.getNews()
        if (response.code() == 200 && response.isSuccessful){
            return response.body()?.data
        }else{
            return emptyList()
        }
    }
}