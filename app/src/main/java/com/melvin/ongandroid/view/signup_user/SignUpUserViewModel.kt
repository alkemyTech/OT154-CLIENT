package com.melvin.ongandroid.view.UserRegisterView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.utils.Validator

class SignUpUserViewModel: ViewModel() {

    private val _buttonRegisterIsEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val buttonRegisterIsEnabled: LiveData<Boolean> = _buttonRegisterIsEnabled
    private val _errorMsgIsEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val errorMsgIsEnabled: LiveData<Boolean> = _errorMsgIsEnabled



    fun validateButtonRegister(firstName: String, lastName:String, email: String,
    password: String, confirmPass: String){

        _buttonRegisterIsEnabled.postValue(
            firstName.isNotEmpty() && lastName.isNotEmpty()
                    && email.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()
                    && passwordAndConfirmPasswordIsEquals(password, confirmPass)
                    && Validator.isEmailValid(email)
                    && Validator.isPasswordValid(password)
        )

    }

    private fun passwordAndConfirmPasswordIsEquals(pass: String, cPass: String):Boolean{
        if (pass == cPass){
            _errorMsgIsEnabled.postValue(false)
            return true
        }
        _errorMsgIsEnabled.postValue(true)
        return false
    }
}