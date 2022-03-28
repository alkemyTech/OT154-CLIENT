package com.melvin.ongandroid.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin.ongandroid.R
import com.melvin.ongandroid.application.ComponentUtils
import com.melvin.ongandroid.application.DataState
import com.melvin.ongandroid.data.datasource.TestimonialDataSourceImpl
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.remote.firebase.FirebaseEvent
import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.repository.TestimonialRepositoryImpl
import com.melvin.ongandroid.databinding.FragmentTestimonialsBinding
import com.melvin.ongandroid.presentation.testimonial.TestimonialViewModel
import com.melvin.ongandroid.presentation.testimonial.TestimonialViewModelFactory
import com.melvin.ongandroid.view.fragments.testimonial.TestimonialsAdapter
import com.melvin.ongandroid.view.fragments.testimonial.TestimonialsAdapterFull

class Reviews : Fragment() {

    private lateinit var binding: FragmentTestimonialsBinding
    private lateinit var adapterTestimonials: TestimonialsAdapterFull
    private val repository = TestimonialRepositoryImpl(TestimonialDataSourceImpl(APIManager()))
    private lateinit var viewModel: TestimonialViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        initViewModel()
        subscribeLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestimonialsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun handleUiTestimonials(uiState: DataState<MutableList<Testimonial>>) {
        when (uiState) {
            is DataState.Success<MutableList<Testimonial>> -> {
                adapterTestimonials.setTestimonials(uiState.data)
                handlerErrorVisibility(false)
                handlerProgressBarVisibility(false)
                handlerRecyclerVisibility(true)
                FirebaseEvent.setLogEvent(requireContext(),"testimonios_retrieve_success")
            }
            is DataState.Error -> {
                handlerErrorVisibility(true)
                handlerProgressBarVisibility(false)
                handlerRecyclerVisibility(false)
                FirebaseEvent.setLogEvent(requireContext(),"testimonies_retrieve_error")
            }
            is DataState.Loading -> {
                handlerErrorVisibility(false)
                handlerProgressBarVisibility(true)
                handlerRecyclerVisibility(false)
            }
            is DataState.Idle -> Unit
        }
    }

    private fun initViewModel() {
        TestimonialViewModelFactory(repository).run {
            viewModel = ViewModelProvider(this@Reviews, this)[TestimonialViewModel::class.java]
        }
    }

    private fun showError() {
        ComponentUtils.showToast(requireContext(), "Ha ocurrido un error")
    }

    private fun subscribeLiveData() {
        with(viewModel) {
            getTestimonials()
            testimonials.observe(viewLifecycleOwner) {
                handleUiTestimonials(it)
            }
        }
    }

    private fun setupRecyclerView() {
        adapterTestimonials = TestimonialsAdapterFull()
        with(binding.rvTestimonial) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = adapterTestimonials
        }
    }
    private fun handlerProgressBarVisibility(show: Boolean) {
        with(binding) {
            iProgressBar.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerRecyclerVisibility(show: Boolean) {
        with(binding) {
            rvTestimonial.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerErrorVisibility(show: Boolean) {
        with(binding) {
            iGenericError.clGenericError.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}