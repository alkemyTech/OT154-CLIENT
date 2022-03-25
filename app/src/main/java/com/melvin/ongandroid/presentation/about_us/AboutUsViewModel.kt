package com.melvin.ongandroid.presentation.about_us

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.repository.MembersInteractor
import kotlinx.coroutines.launch

class AboutUsViewModel : ViewModel() {

    private var getMembersInteractor = MembersInteractor()

    private val _members: MutableLiveData<List<MembersModel>> = MutableLiveData()
    val members: LiveData<List<MembersModel>> = _members

    private val _recyclerShutDown: MutableLiveData<Boolean> = MutableLiveData()
    val recyclerShutDown: LiveData<Boolean> = _recyclerShutDown


    fun getListMembers() {

        viewModelScope.launch {
            val membersInteractor: List<MembersModel> = getMembersInteractor()
            val membersList = mutableListOf<MembersModel>()
            if (membersInteractor.isNotEmpty()) {
                for (members in membersInteractor) {
                    membersList.add(members)
                }
                _members.postValue(membersList)
            } else {
                _recyclerShutDown.postValue(true)
            }
        }
    }

}