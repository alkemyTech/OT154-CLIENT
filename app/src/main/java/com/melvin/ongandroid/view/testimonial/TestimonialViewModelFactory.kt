package com.melvin.ongandroid.view.testimonial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.data.repository.TestimonialRepository

class TestimonialViewModelFactory(private val repository: TestimonialRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TestimonialRepository::class.java)
            .newInstance(repository)
    }
}