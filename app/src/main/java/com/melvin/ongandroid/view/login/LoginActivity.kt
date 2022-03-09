package com.melvin.ongandroid.view.login

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
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
import com.melvin.ongandroid.view.utils.Validator
import com.melvin.ongandroid.viewmodel.login.LoginViewModel
import com.melvin.ongandroid.viewmodel.login.base.LoginViewModelFactory
import kotlinx.coroutines.launch

/**
 * Activity para Login de la aplicacion
 * @author Jose Luis Mora
 */

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

        setObserver()

        binding.etEmail.addTextChangedListener(logInTextWatcher())
        binding.etPassword.addTextChangedListener(logInTextWatcher())

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpUserActivity::class.java))
        }

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

    /**
     * Funsion que setea el observer del Login
     */
    private fun setObserver(){
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
    }

    /**
     * Funsion que verifica si el email y las password cumplen con las ocndiciones, el boton de
     * login cambia de color y se habilita
     */
    private fun logInTextWatcher() : TextWatcher = object  : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if(email.isNotEmpty() && password.isNotEmpty()
                && Validator.isEmailValid(email) ==  true
                && Validator.isPasswordValid(password) == true){
                binding.btnLogin.setBackgroundColor(Color.RED)
                binding.btnLogin.setTextColor(Color.WHITE)
                binding.btnLogin.isEnabled =  true
            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}