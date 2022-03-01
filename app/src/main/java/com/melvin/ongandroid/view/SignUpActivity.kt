package com.melvin.ongandroid.view

/*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ActivitySignUpBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SignUpActivity : AppCompatActivity{

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



    private fun apiErrorView() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.error)
            .setMessage(R.string.sign_up_error)
            .setPositiveButton(R.string.ok) { _, _ ->
                with(binding) {
                    tilPassword.isEndIconVisible = false
                    etEmail.error = getString(R.string.error)
                    etPassword.error = getString(R.string.error)
                    etUsername.error = getString(R.string.error)
                    etConfirmPassword.error = getString(R.string.error)
                }
            }
            .show()
    }

    private fun errorViewsListeners() {
        binding.etConfirmPassword.addTextChangedListener {
            cancelErrorViews()
        }
        binding.etPassword.addTextChangedListener {
            cancelErrorViews()
        }
        binding.etEmail.addTextChangedListener {
            cancelErrorViews()
        }
        binding.etUsername.addTextChangedListener {
            cancelErrorViews()
        }
    }

    private fun cancelErrorViews() {
        binding.etUsername.error = null
        binding.etEmail.error = null
        binding.etPassword.error = null
        binding.etConfirmPassword.error = null
        binding.tilPassword.isEndIconVisible = true
        binding.tilConfirmPassword.isEndIconVisible = true

    }
}
*/