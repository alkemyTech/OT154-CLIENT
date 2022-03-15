package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Contact

interface ContactDataSource {
   suspend fun saveContact(contact: Contact): ResponseApi<Contact>
}