package com.melvin.ongandroid.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
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
        init()
    }

    /*Funcion inicializadora, que toma en conjunto las funciones necesarias para el Fragment.
    Mauro Peña.
     */

    private fun init() {
        setCarrouselObserver()
        binding.btnRetry.setOnClickListener {
            viewModel.getListActivities()
            setCarrouselObserver()
        }
    }

    /*Funcion creada por Martin Re, para el agregado de items, en el display de los carousels.
    Mauro Peña.***
     */

    private fun setCarrouselObserver() {
        viewModel.activities.observe(viewLifecycleOwner) { activities ->
            binding.carousel.addData(activities)
            binding.lastestNewsCarousel.addData(viewModel.addItems())

        }

        /*En Caso de no obtener datos para mostrar en las listas, se vera un boton retry,
        y un error en pantalla.
        Mauro Peña.
         */

        viewModel.carouselIsgone.observe(viewLifecycleOwner) { visible ->
            if (visible) {
                binding.news.isGone = true
                binding.welcome.isGone = true
                binding.btnRetry.isVisible = true
                binding.textviewError.isVisible = true
            }

        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getListActivities()
    }
}