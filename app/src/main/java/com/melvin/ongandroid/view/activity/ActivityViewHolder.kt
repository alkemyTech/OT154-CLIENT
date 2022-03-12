package com.melvin.ongandroid.view.activity

import android.view.View
import android.webkit.URLUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.ItemActivityBinding
import com.melvin.ongandroid.model.activity.Activity

class ActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemActivityBinding.bind(view)

    fun bind(activity: Activity) {
        with(binding) {
            tvName.text = activity.name
            tvNameDescription.text = activity.description
            tvDatePubli.text = activity.created
            activity.image.let {
                if(!it.isNullOrEmpty() && URLUtil.isValidUrl(it))
                    Glide.with(root.context).load(it).into(ivPhoto)
                else
                    Glide.with(root.context).load(R.drawable.ic_image_off).into(ivPhoto)
            }
        }
    }
}