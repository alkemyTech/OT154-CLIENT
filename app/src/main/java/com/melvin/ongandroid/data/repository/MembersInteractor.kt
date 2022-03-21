package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.MembersModel

class MembersInteractor {

    private val repository = MembersRepository()

    suspend operator fun  invoke(): List<MembersModel>{
        val listMembers = repository.getMemberFromApi()
        return if (listMembers.isNullOrEmpty()){
            emptyList()
        } else{
            listMembers
        }
    }
}