package com.melvin.ongandroid.view.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin.ongandroid.data.apiservice.APIActivityManager
import com.melvin.ongandroid.data.datasource.ActivityDataSourceImpl
import com.melvin.ongandroid.data.repository.ActivityRepositoryImpl
import com.melvin.ongandroid.databinding.FragmentActivitiesBinding
import com.melvin.ongandroid.model.activity.Activity
import com.melvin.ongandroid.view.utils.ComponentUtils
import com.melvin.ongandroid.view.utils.DataState

class ActivitiesFragment : Fragment() {

    private lateinit var binding: FragmentActivitiesBinding
    private lateinit var adapterActivities: ActivityAdapter
    private val repository = ActivityRepositoryImpl(
        ActivityDataSourceImpl(
            APIActivityManager()
        )
    )
    private lateinit var viewModel: ActivityViewModel


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
        binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun handleUiTestimonials(uiState: DataState<MutableList<Activity>>) {
        when (uiState) {
            is DataState.Success<MutableList<Activity>> -> {
                adapterActivities.setActivities(uiState.data)
                handlerErrorVisibility(false)
                handlerProgressBarVisibility(false)
                handlerRecyclerVisibility(true)
            }
            is DataState.Error -> {
                handlerErrorVisibility(true)
                handlerProgressBarVisibility(false)
                handlerRecyclerVisibility(false)
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
        ActivityViewModelFactory(repository).run {
            viewModel = ViewModelProvider(this@ActivitiesFragment, this)[ActivityViewModel::class.java]
        }
    }

    private fun showError() {
        ComponentUtils.showToast(requireContext(), "Ha ocurrido un error")
    }

    private fun subscribeLiveData() {
        with(viewModel) {
            getActivities()
            activities.observe(viewLifecycleOwner) {
                handleUiTestimonials(it)
            }
        }
    }

    private fun setupRecyclerView() {
        adapterActivities = ActivityAdapter()
        with(binding.rvActivities) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = adapterActivities
        }
    }
    private fun handlerProgressBarVisibility(show: Boolean) {
        with(binding) {
            iProgressBar.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerRecyclerVisibility(show: Boolean) {
        with(binding) {
            rvActivities.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerErrorVisibility(show: Boolean) {
        with(binding) {
            iGenericError.clGenericError.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}