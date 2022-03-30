package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.local.model.Activity
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.remote.response.ResponseApi
import kotlinx.coroutines.flow.Flow

interface MemberRepository {
    fun getMembers(): Flow<Response<ResponseApi<MutableList<MembersModel>>>>

}