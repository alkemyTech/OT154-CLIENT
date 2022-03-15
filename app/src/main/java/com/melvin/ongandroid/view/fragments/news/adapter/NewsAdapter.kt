package com.melvin.ongandroid.view.fragments.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.local.model.NewsModel


class NewsAdapter(private var newsList: List<NewsModel>): RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater=  LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.item_news, parent, false))

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = newsList.size

    fun setNews(news: MutableList<NewsModel>){
        this.newsList = news
        notifyDataSetChanged()
    }
}