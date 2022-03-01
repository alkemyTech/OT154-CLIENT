package com.melvin.ongandroid.view.signup_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ActivitySignUpUserBinding
import com.melvin.ongandroid.view.UserRegisterView.SignUpUserViewModel
import android.text.Editable
import android.text.TextWatcher

class SignUpUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpUserBinding
    private val viewModel by viewModels<SignUpUserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonRegisterIsEnabled(false)

        binding.textFieldUsernameUserRegisterView.addTextChangedListener(signUpTextWatcher())
        binding.textFieldEmailUserRegisterView.addTextChangedListener(signUpTextWatcher())
        binding.textFieldPasswordUserRegisterView.addTextChangedListener(signUpTextWatcher())
        binding.textFieldConfirmPasswordUserRegisterView.addTextChangedListener(signUpTextWatcher())

        setObserver()
    }

    private fun signUpTextWatcher():TextWatcher = object: TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val userName = binding.textFieldUsernameUserRegisterView.text.toString().trim()
            val email = binding.textFieldEmailUserRegisterView.text.toString().trim()
            val password = binding.textFieldPasswordUserRegisterView.text.toString().trim()
            val confirmPass = binding.textFieldConfirmPasswordUserRegisterView.text.toString().trim()

            viewModel.validateButtonRegister(userName,  email,
                password, confirmPass)

        }

        override fun afterTextChanged(p0: Editable?) {

        }

    }

    private fun buttonRegisterIsEnabled(value:Boolean){
        binding.buttonRegisterUserRegisterView.isEnabled = value
    }


    private fun setErrorMsg(value: Boolean){
        if (value)
            binding.textViewMsgErrorPasswordUserRegisterView.text =
                resources.getString(R.string.string_error_password_not_equals_user_register_view)
        else
            binding.textViewMsgErrorPasswordUserRegisterView.text = ""

    }

    private fun setObserver(){
        viewModel.buttonRegisterIsEnabled.observe(this, {
                b -> buttonRegisterIsEnabled(b)
        })

        viewModel.errorMsgIsEnabled.observe(this, {
                e -> setErrorMsg(e)
        })

}
}