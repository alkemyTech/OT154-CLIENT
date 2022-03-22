package com.melvin.ongandroid.view.fragments.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.Activity

class ActivityAdapter() : RecyclerView.Adapter<ActivityViewHolder>() {
    private var activities: MutableList<Activity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActivityViewHolder(
            layoutInflater.inflate(
                R.layout.item_activity,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderAvtivity: ActivityViewHolder, position: Int) {
        val item = activities[position]
        holderAvtivity.bind(item)
    }

    override fun getItemCount(): Int = activities.size

    fun setActivities(activities: MutableList<Activity>) {
        this.activities = activities
        notifyDataSetChanged()
    }


}