package com.melvin.ongandroid.view.signup_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.view.utils.Validator


class SignUpUserViewModel : ViewModel() {

    private val _buttonRegisterIsEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val buttonRegisterIsEnabled: LiveData<Boolean> = _buttonRegisterIsEnabled
    private val _errorMsgIsEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val errorMsgIsEnabled: LiveData<Boolean> = _errorMsgIsEnabled


    fun validateButtonRegister(
        userName: String, email: String,
        password: String, confirmPass: String
    ) {

        _buttonRegisterIsEnabled.postValue(
            userName.isNotEmpty()
                    && email.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()
                    && passwordAndConfirmPasswordIsEquals(password, confirmPass)
                    && Validator.isEmailValid(email)
                    && Validator.isPasswordValid(password)
        )

    }

    private val _progressBarStatus = MutableLiveData(false)
    val progressBarStatus
        get() = _progressBarStatus

    private fun passwordAndConfirmPasswordIsEquals(pass: String, cPass: String): Boolean {
        if (pass == cPass) {
            _errorMsgIsEnabled.postValue(false)
            return true
        }
        _errorMsgIsEnabled.postValue(true)
        return false
    }

    /* fun registerNewUser(email: String,name: String, password: String, context: Context) {

       val retrofit = Retrofit2.getRetrofit().create(APITestimonialService::class.java)

        retrofit.postNewUser(email, name, password)
            .enqueue(object :
                Callback<NewUserResponse> {
                override fun onFailure(call: Call<NewUserResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<NewUserResponse>,
                    response: Response<NewUserResponse>
                ) {
                    Toast.makeText(context, response.body()?.message, Toast.LENGTH_LONG).show()
                }

            })
    }*/
}