package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.data.remote.network.RetrofitInstance
import com.melvin.ongandroid.data.remote.response.ResponseApi

class APIContactManager {

    suspend fun saveContact(contact: Contact): ResponseApi<MutableList<Contact>> {
        return getRetrofitInstance().saveContact(contact)
    }

    private fun getRetrofitInstance(): APIContactService {
        return RetrofitInstance.getRetrofit().create(APIContactService::class.java)
    }
}