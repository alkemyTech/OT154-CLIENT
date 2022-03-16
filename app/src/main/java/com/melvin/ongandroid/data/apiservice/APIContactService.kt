package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact
import retrofit2.http.Body
import retrofit2.http.POST

interface APIContactService {
    @POST("api/contacts")
    suspend fun saveContact(@Body contact: Contact): ResponseApi<MutableList<Contact>>
}