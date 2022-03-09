package com.melvin.ongandroid.view.login.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.melvin.ongandroid.data.apiservice.Retrofit2
import com.melvin.ongandroid.data.login.preferences.LoginUserPreferences
import com.melvin.ongandroid.data.login.repository.LoginBaseRepository
import com.melvin.ongandroid.viewmodel.login.base.LoginViewModelFactory

/**
 * Clase base ara creacion de fragment login, queda deprecado
 * @author Jose Luis Mora
 */

abstract class BaseLoginFragment<VM: ViewModel, VB: ViewBinding, R: LoginBaseRepository>: Fragment() {

    protected lateinit var loginUserPreferences: LoginUserPreferences
    protected lateinit var binding:VB
    protected lateinit var viewModel:VM
    protected var loginRemoteDataSource =  Retrofit2()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginUserPreferences = LoginUserPreferences(requireContext())
        binding = getFragmentBinding(inflater,container)
        val factory = LoginViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater, conteiner: ViewGroup?): VB
    abstract fun getFragmentRepository(): R

}