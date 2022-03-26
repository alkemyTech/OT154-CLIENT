package com.melvin.ongandroid.view.fragments.about_us.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.MembersModel

class AboutUsAdapter(): RecyclerView.Adapter<AboutUsViewHolder>() {
    private var members: MutableList<MembersModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutUsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AboutUsViewHolder(
            layoutInflater.inflate(
                R.layout.item_about_us,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AboutUsViewHolder, position: Int) {
        val item = members[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = members.size

    fun setMembers(members: MutableList<MembersModel>) {
        this.members = members
        notifyDataSetChanged()
    }
}