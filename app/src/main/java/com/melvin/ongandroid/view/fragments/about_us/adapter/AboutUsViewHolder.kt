package com.melvin.ongandroid.view.fragments.about_us.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.databinding.ItemAboutUsBinding

class AboutUsViewHolder(view: View,private val aboutUsListener: AboutUsListener): RecyclerView.ViewHolder(view){
    private val binding = ItemAboutUsBinding.bind(view)

    fun render(members: MembersModel){
        binding.nameMembers.text = members.name
        binding.positionMembers.text = members.description
        Glide.with(binding.imgAboutUs.context).load(members.image).into(binding.imgAboutUs)
        binding.facebookUrl.text = members.facebookUrl
        binding.linkedinUrl.text = members.linkedinUrl
        binding.facebookUrl.setOnClickListener(){
            aboutUsListener.facebookLink(members.facebookUrl)
        }
        binding.linkedinUrl.setOnClickListener(){
            aboutUsListener.linkedinLink(members.linkedinUrl)
        }

    }
}