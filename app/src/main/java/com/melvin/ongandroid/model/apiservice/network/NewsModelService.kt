package com.melvin.ongandroid.model.apiservice.network

/**
 * Clase que devuelve datos de tipo News desde api retrofit
 *
 * @author Martin Re
 */
import com.melvin.ongandroid.data.apiservice.APIService
import com.melvin.ongandroid.data.apiservice.RetrofitInstance
import com.melvin.ongandroid.model.apiservice.apimodel.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsModelService {

    private val retrofit = RetrofitInstance.retrofitBuilder()

    suspend fun getNews(): Response<NewsResponse> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(APIService::class.java).getAllNews()
            response
        }

    }
}