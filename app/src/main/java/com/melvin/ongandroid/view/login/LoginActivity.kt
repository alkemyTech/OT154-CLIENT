package com.melvin.ongandroid.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.apiservice.Retrofit2
import com.melvin.ongandroid.data.login.LoginApiService
import com.melvin.ongandroid.data.login.ResourceLogin
import com.melvin.ongandroid.data.login.preferences.LoginUserPreferences
import com.melvin.ongandroid.data.login.repository.LoginRepository
import com.melvin.ongandroid.databinding.LogInBinding
import com.melvin.ongandroid.view.MainActivity
import com.melvin.ongandroid.view.signup_user.SignUpUserActivity
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import com.melvin.ongandroid.viewmodel.login.base.LoginViewModelFactory
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModels<LoginViewModel>{LoginViewModelFactory(
        LoginRepository(
            Retrofit2.buildApi(LoginApiService::class.java))
    )}

    private lateinit var binding: LogInBinding
    private lateinit var loginUserPreferences: LoginUserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginUserPreferences = LoginUserPreferences(this)

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpUserActivity::class.java))
        }

        viewModel.loginResponse.observe(this, {
            when(it){
                is ResourceLogin.Success -> {

                    lifecycleScope.launch {
                        loginUserPreferences.saveTokenUser(it.value.data.token)
                    }

                    Toast.makeText(this ,it.value.message, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
                is ResourceLogin.Failure -> { Toast.makeText(this, "Error al cargar. ", Toast.LENGTH_LONG).show()}
            }
        })

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            Log.d("VALIDATION", "EMAIL: ${email}, PASSWORD: ${password}")
            viewModel.login(email, password)
        }
    }

    //Funcion para mostrar el modal dialog al llamar al endpoint "api/login"

    fun showErrorDialog(title: String, message: String?) {
        val dialog: AlertDialog =
            AlertDialog.Builder(this).setMessage(message).setTitle(title)
                .setNeutralButton(
                    R.string.error_login
                ) { _, _ -> }
                .create()
        dialog.show()
    }
}