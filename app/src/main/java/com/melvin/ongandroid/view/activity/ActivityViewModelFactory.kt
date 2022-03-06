package com.melvin.ongandroid.view.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.data.repository.ActivityRepository

class ActivityViewModelFactory(private val repository: ActivityRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ActivityRepository::class.java)
            .newInstance(repository)
    }
}