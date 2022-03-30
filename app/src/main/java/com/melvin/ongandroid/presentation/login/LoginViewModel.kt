package com.melvin.ongandroid.presentation.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.repository.login.ResourceLogin
import com.melvin.ongandroid.data.repository.login.repository.LoginRepository
import com.melvin.ongandroid.data.local.model.login.LoginModel
import com.melvin.ongandroid.data.remote.firebase.FirebaseAnalyticsObj
import com.melvin.ongandroid.data.remote.firebase.FirebaseEvent
import kotlinx.coroutines.launch

/**
 * ViewModel para login
 * @author Jose Luis Mora
 */

class LoginViewModel(private val repository: LoginRepository): ViewModel() {

    private val _loginResponse : MutableLiveData<ResourceLogin<LoginModel>> = MutableLiveData()
    val loginResponse: LiveData<ResourceLogin<LoginModel>> get() = _loginResponse

    fun login(email: String?, password: String?) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }


    fun setLogsFirebaseEvents(context: Context, eventName: String){
        eventName.let {
            FirebaseEvent.setLogEvent(context, it)
        }
    }

}