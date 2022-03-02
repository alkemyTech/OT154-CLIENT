package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.datasource.ContactDataSource
import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactRepositoryImpl(private val dataSource: ContactDataSource) :
    ContactRepository {
    override fun saveContact(contact: Contact): Flow<Response<ResponseApi<Contact>>> = flow {
        try {
            val apiResponse = dataSource.saveContact(contact)
            emit(Response.Success(apiResponse))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}