package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun saveContact(contact: Contact): Flow<Response<ResponseApi<MutableList<Contact>>>>
}