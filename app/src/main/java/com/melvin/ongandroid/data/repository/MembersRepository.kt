package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.remote.network.APIManager

class MembersRepository {

    private val apiService = APIManager()

    suspend fun getMemberFromApi(): List<MembersModel>?{
        val response = apiService.getMembers()
        return if (response.success){
            response.data
        } else {
            emptyList()
        }
    }
}