package com.melvin.ongandroid.data.remote.network

import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.local.model.Activity
import com.melvin.ongandroid.data.local.model.MembersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

    suspend fun getMembers(): ResponseApi<MutableList<MembersModel>>{
        return getRetrofitInstance().getAllMembers()
    }

    private suspend fun getRetrofitInstance(): APIService {
        return withContext(Dispatchers.IO){
            val response = RetrofitInstance.getRetrofit().create(APIService::class.java)
             response
        }
    }
}