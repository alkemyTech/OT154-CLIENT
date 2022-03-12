package com.melvin.ongandroid.view.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.repository.ActivityRepository
import com.melvin.ongandroid.view.utils.DataState
import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.model.Testimonial
import com.melvin.ongandroid.model.activity.Activity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ActivityViewModel(private val repository: ActivityRepository) : ViewModel() {
    val activities: LiveData<DataState<MutableList<Activity>>>
        get() = _activities
    private val _activities = MutableLiveData<DataState<MutableList<Activity>>>()

    /*
    Metodo que retorna lista de activities auxiliados por la clase DataState - Leandro Valderas
     */
    fun getActivities() {
        viewModelScope.launch {
            repository.getActivities().onEach {
                when (it) {
                    is Response.NotInitialized, Response.Loading -> {
                        _activities.value = DataState.Loading(loading = true)
                    }
                    is Response.Success -> {
                        _activities.value = DataState.Success(it.data.data)
                    }
                    is Response.Error -> {
                        _activities.value = DataState.Loading(loading = false)
                        _activities.value = DataState.Error(it.exception)
                    }
                }
            }.launchIn(this)
        }
    }
}