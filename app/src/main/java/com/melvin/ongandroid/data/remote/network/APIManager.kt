package com.melvin.ongandroid.data.remote.network

import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.local.model.Activity
import com.melvin.ongandroid.data.remote.response.NewsResponse
import com.melvin.ongandroid.data.remote.response.SlideModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class APIManager {

    suspend fun getActivities(): ResponseApi<MutableList<Activity>> {
        return getRetrofitInstance().getActivities()
    }

    suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>> {
        return getRetrofitInstance().getTestimonials()
    }

    suspend fun saveContact(contact: Contact): ResponseApi<Contact> {
        return getRetrofitInstance().saveContact(contact)
    }

    suspend fun getSlides(): Response<SlideModelResponse> {
        return withContext(Dispatchers.IO) {
            getRetrofitInstance().getAllSlides()
        }
    }

    suspend fun getNews(): Response<NewsResponse> {
        return withContext(Dispatchers.IO){
            getRetrofitInstance().getAllNews()
        }
    }


    private fun getRetrofitInstance(): APIService {
        return RetrofitInstance.getRetrofit().create(APIService::class.java)
    }
}