package com.melvin.ongandroid.view.fragments.testimonial

import android.view.View
import android.webkit.URLUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.TestimonialSubItemBinding
import com.melvin.ongandroid.data.local.model.Testimonial

class TestimonialViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = TestimonialSubItemBinding.bind(view)

    fun bind(testimonial: Testimonial) {
        with(binding) {
            ibArrow.setOnClickListener {  }
            ibArrow.visibility = if (absoluteAdapterPosition == 3) View.VISIBLE else View.INVISIBLE
            tvDescription.text = testimonial.descriptionQuotationMarks
            testimonial.image.let {
                if(it.isNotEmpty() && URLUtil.isValidUrl(it))
                    Glide.with(root.context).load(testimonial.image).placeholder(R.drawable.ic_avatar_off).into(civAvatar)
            }
        }
    }
}