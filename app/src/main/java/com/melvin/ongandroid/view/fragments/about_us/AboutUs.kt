package com.melvin.ongandroid.view.fragments.about_us

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.os.bundleOf

import androidx.navigation.fragment.findNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.application.DataState
import com.melvin.ongandroid.data.datasource.MemberDataSourceImpl
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.data.repository.MemberRepositoryImpl
import com.melvin.ongandroid.databinding.FragmentAboutUsBinding
import com.melvin.ongandroid.presentation.about_us.AboutUsViewModel
import com.melvin.ongandroid.presentation.about_us.AboutUsViewModelFactory
import com.melvin.ongandroid.view.fragments.about_us.adapter.AboutUsAdapter
import com.melvin.ongandroid.view.fragments.about_us.adapter.AboutUsListener
import com.melvin.ongandroid.view.fragments.about_us.interfaces.ListenerOnClick


class AboutUs : Fragment(R.layout.fragment_about_us), ListenerOnClick {


    private lateinit var binding: FragmentAboutUsBinding
    private lateinit var adapterMembers: AboutUsAdapter
    private lateinit var viewModel: AboutUsViewModel

    private val repository = MemberRepositoryImpl(
        MemberDataSourceImpl(
            APIManager()
        )
    )


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
        binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        return binding.root

    }


//    private fun setAdapter(membersList:List<MembersModel>){
//        binding.recyclerAboutUs.adapter = AboutUsAdapter(membersList)
//    }



//    private fun setRecyclerObserver(){
//        viewModel.getListMembers()
//        viewModel.members.observe(viewLifecycleOwner){
//            setAdapter(it)
//        }
//
//        viewModel.recyclerShutDown.observe(viewLifecycleOwner){
//            if (it){
//                binding.recyclerAboutUs.isGone = true
//                binding.txtMiembros.isGone = true
//                binding.messageNosotros.isGone = true
//            }
//        }
//    }

    private fun handleUiMembers(uiState: DataState<MutableList<MembersModel>>) {
        when (uiState) {
            is DataState.Success<MutableList<MembersModel>> -> {
                adapterMembers.setMembers(uiState.data)
                handlerErrorVisibility(false)
                handlerProgressBarVisibility(false)
                handlerRecyclerVisibility(true)
            }
            is DataState.Error -> {
                handlerErrorVisibility(true)
                handlerProgressBarVisibility(false)
                handlerRecyclerVisibility(false)
                reloadRecyclerView()
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
        AboutUsViewModelFactory(repository).run {
            viewModel = ViewModelProvider(this@AboutUs, this)[AboutUsViewModel::class.java]
        }
    }

    private fun reloadRecyclerView(){
        with(binding){
            aboutUsError.btnRetry.setOnClickListener {
                viewModel.getListMembers()
            }
        }
    }

    override fun navigateToMemberDetailsFragment(member: MembersModel){
        val obMember: MembersModel = member
        val bundle = bundleOf("detailsMember" to obMember)
        findNavController().navigate(R.id.action_navFragmentAboutUs_to_navFragmentDetailsMember, bundle)


    }


    private fun setupRecyclerView() {
        adapterMembers = AboutUsAdapter(this)
        with(binding.recyclerAboutUs) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = adapterMembers
        }
    }


    private fun subscribeLiveData() {
        with(viewModel) {
            getListMembers()
            members.observe(viewLifecycleOwner) {
                handleUiMembers(it)
            }
        }
    }

    private fun handlerProgressBarVisibility(show: Boolean) {
        with(binding) {
            iProgressBar.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerRecyclerVisibility(show: Boolean) {
        with(binding) {
            recyclerAboutUs.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerErrorVisibility(show: Boolean) {
        with(binding) {
            aboutUsError.root.visibility = if (show) View.VISIBLE else View.GONE
        }
    }




}