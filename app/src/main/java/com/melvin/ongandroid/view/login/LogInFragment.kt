package com.melvin.ongandroid.view.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.melvin.ongandroid.data.apiservice.Retrofit2
import com.melvin.ongandroid.data.login.LoginApiService
import com.melvin.ongandroid.data.login.ResourceLogin
import com.melvin.ongandroid.data.login.repository.LoginBaseRepository
import com.melvin.ongandroid.data.login.repository.LoginRepository
import com.melvin.ongandroid.databinding.LogInBinding
import com.melvin.ongandroid.view.login.base.BaseLoginFragment
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import kotlinx.coroutines.launch

class LogInFragment: BaseLoginFragment<LoginViewModel, LogInBinding, LoginBaseRepository>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is ResourceLogin.Success -> {

                    lifecycleScope.launch {
                        loginUserPreferences.saveTokenUser(it.value.data.token)
                    }

                    Toast.makeText(requireContext(),it.value.message, Toast.LENGTH_SHORT).show()
                }
                is ResourceLogin.Failure -> { Toast.makeText(requireContext(), "Error al cargar. ", Toast.LENGTH_LONG).show()}
            }
        })

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            Log.d("VALIDATION", "EMAIL: ${email}, PASSWORD: ${password}")
            viewModel.login(email, password)
        }

    }

    override fun getViewModel() = LoginViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        conteiner: ViewGroup?) = LogInBinding.inflate(inflater, conteiner, false)

    override fun getFragmentRepository() = LoginRepository(Retrofit2.buildApi(LoginApiService::class.java))
}