package com.melvin.ongandroid.view.fragments.about_us.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.databinding.ItemAboutUsBinding
import com.melvin.ongandroid.view.fragments.about_us.interfaces.ListenerOnClick


class AboutUsViewHolder(view: View,
                        private val click: ListenerOnClick,
                        private var membersList: List<MembersModel>)
    : RecyclerView.ViewHolder(view), View.OnClickListener{

    private val binding = ItemAboutUsBinding.bind(view)

    init {
        itemView.setOnClickListener (this)
    }

    fun render(members: MembersModel){
        binding.nameMembers.text = members.name
        binding.positionMembers.text = members.description
        Glide.with(binding.imgAboutUs.context).load(members.image).into(binding.imgAboutUs)

    }

    override fun onClick(p0: View?) {
        val currentMember = membersList[adapterPosition]
        click.navigateToMemberDetailsFragment(currentMember)
    }


}