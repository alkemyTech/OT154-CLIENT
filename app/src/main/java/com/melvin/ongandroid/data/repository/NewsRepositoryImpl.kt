package com.melvin.ongandroid.data.repository

/**
 * Esta clase obtiene un response de las novedades de la ONG.
 * Ya sea desde un repositorio remoto o local
 *
 * @author Martin Re
 */
import com.melvin.ongandroid.data.datasource.NewsDataSource
import com.melvin.ongandroid.data.datasource.NewsDataSourceImpl
import com.melvin.ongandroid.data.local.model.NewsModel

class NewsRepositoryImpl: NewsRepository() {

    private val dataSource: NewsDataSource = NewsDataSourceImpl()

    override suspend fun getAllNewsFromApi(): List<NewsModel>? {
        val response = dataSource.getNews()
        return if (response.code() == 200 && response.isSuccessful){
            response.body()?.data
        }else{
            emptyList()
        }
    }
}