package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.data.remote.response.ResponseApi
import retrofit2.http.Body
import retrofit2.http.POST

interface APIContactService {
    @POST("api/contacts")
    suspend fun saveContact(@Body contact: Contact): ResponseApi<MutableList<Contact>>
}