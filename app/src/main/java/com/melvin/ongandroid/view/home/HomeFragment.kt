package com.melvin.ongandroid.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.viewmodel.HomeViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        setCarrouselObserver()

    }

    private fun setCarrouselObserver(){
        viewModel.activities.observe(this, {
                activities ->
            binding.carousel.addData(activities)
        })

        viewModel.carouselIsgone.observe(this, {
                visible -> if (visible) binding.carousel.isGone = true
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getListActivities()
    }
}