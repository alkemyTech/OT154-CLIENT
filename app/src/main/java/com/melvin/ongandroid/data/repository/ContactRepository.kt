package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun saveContact(contact: Contact): Flow<Response<ResponseApi<Contact>>>
}