package com.melvin.ongandroid.view.fragments.about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.databinding.FragmentAboutUsBinding
import com.melvin.ongandroid.presentation.about_us.AboutUsViewModel
import com.melvin.ongandroid.view.fragments.about_us.adapter.AboutUsAdapter

class AboutUs : Fragment(R.layout.fragment_about_us) {

    private lateinit var binding: FragmentAboutUsBinding
    private val viewModel by viewModels<AboutUsViewModel>()
    private lateinit var listMembers: List<MembersModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutUsBinding.bind(view)
        setRecyclerObserver()
    }
    private fun setAdapter(membersList:List<MembersModel>){
        binding.recyclerAboutUs.adapter = AboutUsAdapter(membersList)
    }
    private fun setRecyclerObserver(){
        viewModel.getListMembers()
        viewModel.members.observe(viewLifecycleOwner){
            setAdapter(it)
        }

        viewModel.recyclerShutDown.observe(viewLifecycleOwner){
            if (it){
                binding.recyclerAboutUs.isGone = true
                binding.txtMiembros.isGone = true
                binding.messageNosotros.isGone = true
            }
        }
    }

}