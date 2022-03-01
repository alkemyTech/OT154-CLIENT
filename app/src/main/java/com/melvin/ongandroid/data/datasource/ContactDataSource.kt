package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact

interface ContactDataSource {
   suspend fun saveContact(contact: Contact): ResponseApi<Contact>
}