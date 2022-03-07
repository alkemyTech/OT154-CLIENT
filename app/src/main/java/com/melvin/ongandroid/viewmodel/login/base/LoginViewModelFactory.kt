package com.melvin.ongandroid.viewmodel.login.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.data.login.repository.LoginBaseRepository
import com.melvin.ongandroid.data.login.repository.LoginRepository
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import java.lang.IllegalArgumentException

class LoginViewModelFactory(private val repository: LoginBaseRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as LoginRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class No Found")
        }
    }

}