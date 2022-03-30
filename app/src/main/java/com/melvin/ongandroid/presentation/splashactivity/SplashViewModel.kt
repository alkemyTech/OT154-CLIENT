package com.melvin.ongandroid.presentation.splashactivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.repository.login.preferences.LoginUserPreferences
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private var _userIsLogged: MutableLiveData<Boolean> = MutableLiveData()
    val userIsLogged: LiveData<Boolean> = _userIsLogged

    fun setSharedPreferences(context: Context){
         var loginUserPreferences = LoginUserPreferences(context)
        viewModelScope.launch {
            val token = loginUserPreferences.getTokenUser()
            if (token != "")
            {
                _userIsLogged.postValue(true)
            }else{
                _userIsLogged.postValue(false)
            }

        }

    }
}