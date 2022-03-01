package com.melvin.ongandroid.view.testimonial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.data.repository.TestimonialsRepository

class TestimonialViewModelFactory(private val repository: TestimonialsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TestimonialsRepository::class.java)
            .newInstance(repository)
    }
}