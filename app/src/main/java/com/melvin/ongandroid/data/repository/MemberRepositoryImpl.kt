package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.datasource.ContactDataSource
import com.melvin.ongandroid.data.datasource.MemberDataSource
import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.remote.response.ResponseApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MemberRepositoryImpl(private val dataSource: MemberDataSource) :
    MemberRepository {
    override fun getMembers(): Flow<Response<ResponseApi<MutableList<MembersModel>>>> = flow {
        try {
            val apiResponse = dataSource.getMembers()
            emit(Response.Success(apiResponse))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
//    private val apiService = APIManager()
//
//    suspend fun getMemberFromApi(): List<MembersModel>{
//        val response = apiService.getMembers()
//        return if (response.success){
//            response.data
//        } else {
//            emptyList()
//        }
//    }
}