package com.melvin.ongandroid.view.testimonial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.model.Testimonial

class TestimonialsAdapter() : RecyclerView.Adapter<TestimonialViewHolder>() {
    private var testimonials: MutableList<Testimonial> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TestimonialViewHolder(
            layoutInflater.inflate(
                R.layout.testimonial_sub_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderTestimonial: TestimonialViewHolder, position: Int) {
        val item = testimonials[position]
        holderTestimonial.bind(item)
    }

    override fun getItemCount(): Int = if (testimonials.size >= 4) 4 else testimonials.size
//    override fun getItemCount(): Int = testimonials.size

    fun setTestimonials(testimonials: MutableList<Testimonial>) {
        this.testimonials = testimonials
        notifyDataSetChanged()
    }


}