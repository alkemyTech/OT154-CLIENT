package com.melvin.ongandroid.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.LogInBinding
import com.melvin.ongandroid.view.signup_user.SignUpUserActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpUserActivity::class.java))
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