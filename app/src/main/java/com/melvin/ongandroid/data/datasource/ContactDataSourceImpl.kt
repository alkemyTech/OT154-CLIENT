package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Contact

class ContactDataSourceImpl(private val service: APIManager): ContactDataSource {
    override suspend fun saveContact(contact: Contact): ResponseApi<Contact> {
        return service.saveContact(contact)
    }
}
