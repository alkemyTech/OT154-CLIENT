package com.melvin.ongandroid.presentation.login.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.data.repository.login.repository.LoginBaseRepository
import com.melvin.ongandroid.data.repository.login.repository.LoginRepository
import com.melvin.ongandroid.presentation.login.LoginViewModel
import java.lang.IllegalArgumentException

/**
 * Clase de viewModel Factory para proveeer viewmodel en la aplicacion
 * @author Jose Luis Mora
 */

class LoginViewModelFactory(private val repository: LoginBaseRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as LoginRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class No Found")
        }
    }

}