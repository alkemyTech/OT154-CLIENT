package com.melvin.ongandroid.view.contact_us

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.repository.ContactRepository
import com.melvin.ongandroid.view.utils.DataState
import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.model.Contact
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ContactUsViewModel(private val repository: ContactRepository) : ViewModel() {
    val contacts: LiveData<DataState<MutableList<Contact>>>
        get() = _contacts
    private val _contacts = MutableLiveData<DataState<MutableList<Contact>>>()

    //Metodo que salva contacto - Valderas Leandro

    fun saveContact(contact: Contact) {
        viewModelScope.launch {
            repository.saveContact(contact).onEach {
                when (it) {
                    is Response.NotInitialized, Response.Loading -> {
                        _contacts.value = DataState.Loading(loading = true)
                    }
                    is Response.Success -> {
                        _contacts.value = DataState.Success(it.data.data)

                    }
                    is Response.Error -> {
                        _contacts.value = DataState.Loading(loading = false)
                        _contacts.value = DataState.Error(it.exception)
                    }
                }
            }.launchIn(this)
        }
    }
}