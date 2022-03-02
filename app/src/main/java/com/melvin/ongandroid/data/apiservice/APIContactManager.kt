package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact

class APIContactManager {

    suspend fun saveContact(contact: Contact): ResponseApi<Contact> {
        return getRetrofitInstance().saveContact(contact)
    }

    private fun getRetrofitInstance(): APIContactService {
        return Retrofit2.getRetrofit().create(APIContactService::class.java)
    }
}