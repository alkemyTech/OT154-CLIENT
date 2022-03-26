package com.melvin.ongandroid.view.fragments.about_us

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.databinding.FragmentAboutUsBinding
import com.melvin.ongandroid.presentation.about_us.AboutUsViewModel
import com.melvin.ongandroid.utils.EventConstants
import com.melvin.ongandroid.utils.sendLog
import com.melvin.ongandroid.view.fragments.about_us.adapter.AboutUsAdapter
import com.melvin.ongandroid.view.fragments.about_us.interfaces.ListenerOnClick


class AboutUs : Fragment(R.layout.fragment_about_us), ListenerOnClick {

    private lateinit var binding: FragmentAboutUsBinding
    private val viewModel by viewModels<AboutUsViewModel>()
    private lateinit var listMembers: List<MembersModel>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutUsBinding.bind(view)
        activity?.setTitle(R.string.string_title_member_detail_fragment)
        setRecyclerObserver()

    }
    private fun setAdapter(membersList:List<MembersModel>){
        binding.recyclerAboutUs.adapter = AboutUsAdapter(membersList, this)
    }
    private fun setRecyclerObserver(){
        viewModel.getListMembers()
        viewModel.members.observe(viewLifecycleOwner){
            setAdapter(it)
            sendLog(EventConstants.MEMBER_SUCCESS, "Member list retrieved successfully")
        }

        viewModel.recyclerShutDown.observe(viewLifecycleOwner){
            if (it){
                binding.recyclerAboutUs.isGone = true
                binding.txtMiembros.isGone = true
                binding.messageNosotros.isGone = true
            }
        }
    }
    //



    override fun navigateToMemberDetailsFragment(member: MembersModel){
        val obMember: MembersModel = member
        val bundle = bundleOf("detailsMember" to obMember)
        findNavController().navigate(R.id.action_navFragmentAboutUs_to_navFragmentDetailsMember, bundle)


    }


}