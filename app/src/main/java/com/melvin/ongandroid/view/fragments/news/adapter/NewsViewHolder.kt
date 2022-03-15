package com.melvin.ongandroid.view.fragments.news.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.databinding.ItemNewsBinding
import com.melvin.ongandroid.data.local.model.NewsModel

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNewsBinding.bind(view)

    fun render(news: NewsModel) {
        binding.title.text = news.name
        binding.body.text = news.content
        Glide.with(binding.imgNews.context).load(news.image).into(binding.imgNews)
    }
}