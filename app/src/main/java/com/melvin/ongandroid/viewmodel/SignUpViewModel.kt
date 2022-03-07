package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.MutableLiveData

class SignUpViewModel {

    private val _progressBarStatus = MutableLiveData(false)
    val progressBarStatus
        get() = _progressBarStatus


}