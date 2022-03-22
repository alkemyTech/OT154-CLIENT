package com.melvin.ongandroid.data.remote.network

/**
 * Clase que devuelve datos de tipo News desde api retrofit
 *
 * @author Martin Re
 */
import com.melvin.ongandroid.data.remote.response.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class NewsModelService {

    private val retrofit = RetrofitInstance.getRetrofit()

    suspend fun getNews(): Response<NewsResponse> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(APIService::class.java).getAllNews()
            response
        }

    }
}