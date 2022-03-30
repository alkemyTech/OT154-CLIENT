package com.melvin.ongandroid.presentation.about_us

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.data.repository.MemberRepository

class AboutUsViewModelFactory(private val repository: MemberRepository): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MemberRepository::class.java)
            .newInstance(repository)
    }
}