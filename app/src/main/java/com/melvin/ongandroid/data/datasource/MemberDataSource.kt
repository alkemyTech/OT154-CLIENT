package com.melvin.ongandroid.data.datasource

import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.remote.response.ResponseApi

interface MemberDataSource {
    suspend fun getMembers(): ResponseApi<MutableList<MembersModel>>

}