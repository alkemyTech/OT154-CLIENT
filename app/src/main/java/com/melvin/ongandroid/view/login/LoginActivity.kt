package com.melvin.ongandroid.view.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.LogInBinding
import com.melvin.ongandroid.view.ProgressActivity
import com.melvin.ongandroid.view.UserRegisterView.SignUpUserViewModel
import com.melvin.ongandroid.viewmodel.LoginViewModel

class LoginActivity : ProgressActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    private lateinit var binding: LogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachLoadingProgressBar(binding.mainView)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.progressBarStatus.observe(this) {
            setCustomProgressBarVisibility(it)
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