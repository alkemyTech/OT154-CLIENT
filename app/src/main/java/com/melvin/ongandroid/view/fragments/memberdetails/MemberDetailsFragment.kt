package com.melvin.ongandroid.view.fragments.memberdetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.databinding.FragmentMemberDetailsBinding
import com.melvin.ongandroid.view.fragments.about_us.adapter.AboutUsListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MemberDetailsFragment : Fragment(R.layout.fragment_member_details), AboutUsListener {

    private lateinit var binding: FragmentMemberDetailsBinding
    private lateinit var request: MembersModel
    val activityScope = CoroutineScope(Dispatchers.Main)

    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMemberDetailsBinding.bind(view)
        request = arguments?.getParcelable<MembersModel>("detailsMember")!!
        setDetailsMember()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.setTitle(R.string.string_title_member_detail_fragment)
    }


    private fun setDetailsMember(){
        activityScope.launch {
            setProfileImage()
        }
        binding.textViewNameMemberFragmentMemberDetail.text = request.name
        binding.textViewDescriptionMemberFragmentMemberDetail.text = request.description
        binding.textViewLinkFacebookUrlFragmentMemberDetail.text = request.facebookUrl
        binding.textViewLinkLinkedinUrlFragmentMemberDetail.text = request.linkedinUrl
        binding.textViewLinkFacebookUrlFragmentMemberDetail.setOnClickListener {
            facebookLink(request.facebookUrl.toString())
        }
        binding.textViewLinkLinkedinUrlFragmentMemberDetail.setOnClickListener {
            linkedinLink(request.linkedinUrl.toString())
        }
    }

    private suspend fun setProfileImage(){
        context?.let {
            Glide.with(it)
                .load(request.image)
                .into(binding.imageMemberFragmentMemberDetail)
        }

    }

    override fun facebookLink(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        ContextCompat.startActivity(requireContext(),browserIntent,null)
    }

    override fun linkedinLink(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        ContextCompat.startActivity(requireContext(),browserIntent,null)
    }

}