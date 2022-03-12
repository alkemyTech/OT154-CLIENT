package com.melvin.ongandroid.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.login.ResourceLogin
import com.melvin.ongandroid.data.login.repository.LoginRepository
import com.melvin.ongandroid.model.login.LoginModel
import kotlinx.coroutines.launch

/**
 * ViewModel para login
 * @author Jose Luis Mora
 */

class LoginViewModel(private val repository: LoginRepository): ViewModel() {

    private val _loginResponse : MutableLiveData<ResourceLogin<LoginModel>> = MutableLiveData()
    val loginResponse: LiveData<ResourceLogin<LoginModel>> get() = _loginResponse
    fun login(email: String?, password: String?) = viewModelScope.launch {
        _progressBarStatus.value = true
        _loginResponse.value = repository.login(email, password)
    }
    private val _progressBarStatus = MutableLiveData(false)
    val progressBarStatus
        get() = _progressBarStatus

}