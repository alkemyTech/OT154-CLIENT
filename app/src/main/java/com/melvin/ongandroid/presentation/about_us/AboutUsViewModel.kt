package com.melvin.ongandroid.presentation.about_us

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.application.DataState
import com.melvin.ongandroid.application.Response
import com.melvin.ongandroid.data.local.model.Activity
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.repository.ActivityRepository
import com.melvin.ongandroid.data.repository.MemberRepository
import com.melvin.ongandroid.data.repository.MembersInteractor
import com.melvin.ongandroid.data.repository.MemberRepositoryImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AboutUsViewModel (private val repository: MemberRepository) : ViewModel() {
    val members: LiveData<DataState<MutableList<MembersModel>>>
        get() = _members
    private val _members = MutableLiveData<DataState<MutableList<MembersModel>>>()


//    fun getListMembers() {
//        viewModelScope.launch {
//            val membersInteractor: List<MembersModel> = getMembersInteractor()
//            val membersList = mutableListOf<MembersModel>()
//            if (membersInteractor.isNotEmpty()) {
//                for (members in membersInteractor) {
//                    membersList.add(members)
//                }
//                _members.postValue(membersList)
//            } else {
//                _recyclerShutDown.postValue(true)
//            }
//        }
//    }

    fun getListMembers() {
        viewModelScope.launch {
            repository.getMembers().onEach {
                when (it) {
                    is Response.NotInitialized, Response.Loading -> {
                        _members.value = DataState.Loading(loading = true)
                    }
                    is Response.Success -> {
                        _members.value = DataState.Success(it.data.data)
                    }
                    is Response.Error -> {
                        _members.value = DataState.Loading(loading = false)
                        _members.value = DataState.Error(it.exception)
                    }
                }
            }.launchIn(this)
        }
    }

}