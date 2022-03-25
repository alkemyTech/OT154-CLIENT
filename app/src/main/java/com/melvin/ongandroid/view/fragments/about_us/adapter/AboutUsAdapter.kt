package com.melvin.ongandroid.view.fragments.about_us.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.MembersModel
import com.melvin.ongandroid.view.fragments.about_us.interfaces.ListenerOnClick

class AboutUsAdapter(private var membersList: List<MembersModel>, private val click: ListenerOnClick) : RecyclerView.Adapter<AboutUsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutUsViewHolder {
       var layoutInflater= LayoutInflater.from(parent.context)
       return AboutUsViewHolder(layoutInflater.inflate(R.layout.item_about_us, parent, false),
           click, membersList)
    }

    override fun onBindViewHolder(holder: AboutUsViewHolder, position: Int) {
        val item = membersList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = membersList.size

}