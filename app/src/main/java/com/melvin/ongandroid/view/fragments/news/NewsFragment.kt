package com.melvin.ongandroid.view.fragments.news
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.melvin.ongandroid.databinding.FragmentNewsBinding
import com.melvin.ongandroid.data.local.model.NewsModel
import com.melvin.ongandroid.view.fragments.news.adapter.NewsAdapter
import com.melvin.ongandroid.presentation.news.NewsViewModel
import com.melvin.ongandroid.R


class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by viewModels<NewsViewModel>()
    private lateinit var listNews: List<NewsModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)

    }


    override fun onResume() {
        super.onResume()
        viewModel.setListNews()
        setObservers()
    }


    private fun setObservers(){
        listNews = listOf()
        viewModel.news.observe(viewLifecycleOwner,{
            setAdapter(it)
        })
        viewModel.progressBarIsEnabled.observe(viewLifecycleOwner, {
            handlerProgressBarVisibility(it)
        })

    }

    private fun setAdapter(news: List<NewsModel>){
        binding.recyclerNews.adapter = NewsAdapter(news)
    }

    private fun handlerProgressBarVisibility(show: Boolean) {
        with(binding) {
            iProgressBar?.progressBar?.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

}