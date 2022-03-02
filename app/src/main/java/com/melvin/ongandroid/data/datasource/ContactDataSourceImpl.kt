package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.apiservice.APIContactManager
import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact

class ContactDataSourceImpl(private val service: APIContactManager): ContactDataSource {
    override suspend fun saveContact(contact: Contact): ResponseApi<Contact> {
        return service.saveContact(contact)
    }
}
