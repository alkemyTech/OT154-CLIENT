package com.melvin.ongandroid.presentation.signup

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.application.Validator
import com.melvin.ongandroid.data.remote.firebase.FirebaseAnalyticsObj
import com.melvin.ongandroid.data.remote.firebase.FirebaseEvent
import com.melvin.ongandroid.data.remote.network.APIService
import com.melvin.ongandroid.data.remote.network.RetrofitInstance
import com.melvin.ongandroid.data.remote.response.NewUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    private fun passwordAndConfirmPasswordIsEquals(pass: String, cPass: String): Boolean {
        if (pass == cPass) {
            _errorMsgIsEnabled.postValue(false)
            return true
        }
        _errorMsgIsEnabled.postValue(true)
        return false
    }

    fun registerNewUser(email: String,name: String, password: String, context: Context) {
        FirebaseEvent.setLogEvent(context, "register_pressed")//Evento firebase. Button registro presionado
       val retrofit = RetrofitInstance.getRetrofit().create(APIService::class.java)

        retrofit.postNewUser(email, name, password)
            .enqueue(object :
                Callback<NewUserResponse> {

                override fun onFailure(call: Call<NewUserResponse>, t: Throwable) {
                    FirebaseEvent.setLogEvent(context, "sign_up_error")//Evento firebase. Error de registro
                }

                override fun onResponse(
                    call: Call<NewUserResponse>,
                    response: Response<NewUserResponse>
                ) {
                    if(response.code() == 200 && response.isSuccessful){
                        FirebaseEvent.setLogEvent(context, "sign_up_success")//Evento firebase.Registro exitoso
                        Toast.makeText(context, response.body()?.message, Toast.LENGTH_LONG).show()
                    }else{
                        FirebaseEvent.setLogEvent(context, "sign_up_error")//Evento firebase. Error de registro
                        Toast.makeText(context, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                }

            })
    }
}