package com.melvin.ongandroid.view.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.view.news.adapter.NewsAdapter
import com.melvin.ongandroid.viewmodel.NewsViewModel

class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by viewModels<NewsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        initRecyclerView()
    }
    fun initRecyclerView(){
        binding.recyclerNews.adapter = NewsAdapter(viewModel.addItems())
    }
}