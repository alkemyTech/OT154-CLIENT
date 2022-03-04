package com.melvin.ongandroid.view.testimonial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.repository.TestimonialRepository
import com.melvin.ongandroid.view.utils.DataState
import com.melvin.ongandroid.view.utils.Response
import com.melvin.ongandroid.model.Testimonial
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TestimonialViewModel(private val repository: TestimonialRepository) : ViewModel() {
    val testimonials: LiveData<DataState<MutableList<Testimonial>>>
        get() = _testimonials
    private val _testimonials = MutableLiveData<DataState<MutableList<Testimonial>>>()

    /*
    Metodo que retorna lista de testiminios auxiliados por la clase DataState
     */
    fun getTestimonials() {
        viewModelScope.launch {
            repository.getTestimonials().onEach {
                when (it) {
                    is Response.NotInitialized, Response.Loading -> {
                        _testimonials.value = DataState.Loading(loading = true)
                    }
                    is Response.Success -> {
                        _testimonials.value = DataState.Success(it.data.data)
                    }
                    is Response.Error -> {
                        _testimonials.value = DataState.Loading(loading = false)
                        _testimonials.value = DataState.Error(it.exception)
                    }
                }
            }.launchIn(this)
        }
    }
}