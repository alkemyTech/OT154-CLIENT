package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.remote.response.ResponseApi

class MemberDataSourceImpl(private val service: APIManager) : MemberDataSource {
    override suspend fun getMembers(): ResponseApi<MutableList<MembersModel>> {
        return service.getMembers()
    }
}