package com.melvin.ongandroid.view.activities.login

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
import androidx.lifecycle.lifecycleScope
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.remote.network.RetrofitInstance
import com.melvin.ongandroid.data.repository.login.ResourceLogin
import com.melvin.ongandroid.data.repository.login.preferences.LoginUserPreferences
import com.melvin.ongandroid.data.repository.login.repository.LoginRepository
import com.melvin.ongandroid.databinding.LogInBinding
import com.melvin.ongandroid.view.MainActivity
import com.melvin.ongandroid.view.activities.signup_user.SignUpUserActivity
import com.melvin.ongandroid.application.Validator
import com.melvin.ongandroid.data.remote.network.APIService
import com.melvin.ongandroid.presentation.login.LoginViewModel
import com.melvin.ongandroid.presentation.login.base.LoginViewModelFactory
import kotlinx.coroutines.launch
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth


/**
 * Activity para Login de la aplicacion
 * @author Jose Luis Mora
 */

class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModels<LoginViewModel>{LoginViewModelFactory(
        LoginRepository(
            RetrofitInstance.buildApi(APIService::class.java))
    )}

    private lateinit var binding: LogInBinding
    private lateinit var loginUserPreferences: LoginUserPreferences
    private val callbackManager = CallbackManager.Factory.create()

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

        binding.ibFacebook.setOnClickListener {
            loginWithFacebook()
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

    //Login with facebook
    fun loginWithFacebook(){
        LoginManager.getInstance().logInWithReadPermissions(this, callbackManager,listOf("email"))
        LoginManager.getInstance().registerCallback(callbackManager,
            object : FacebookCallback<LoginResult>{

                override fun onCancel() {
                    Toast.makeText(this@LoginActivity, "cancel", Toast.LENGTH_SHORT).show()
                }

                override fun onError(error: FacebookException) {
                    showErrorDialog("Error Facebook", "Verify your account")
                }
                override fun onSuccess(result: LoginResult) {
                    result?.let{
                        val token:  AccessToken = it.accessToken
                        val credential: AuthCredential = FacebookAuthProvider.getCredential(token.token)
                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                            if(it.isSuccessful){
                                startActivity(Intent(applicationContext, MainActivity::class.java))
                            }
                            else{
                                showErrorDialog("Error Facebook", "Account not Existing")
                            }
                        }
                    }
                }

            })
    }
}

