package com.melvin.ongandroid.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.data.repository.GetNewsInteractor
import com.melvin.ongandroid.data.local.model.NewsModel
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    private var interactor = GetNewsInteractor()
    private val _news: MutableLiveData<List<NewsModel>> = MutableLiveData()
    val news: LiveData<List<NewsModel>> = _news
    private val _progressBarIsEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val progressBarIsEnabled: LiveData<Boolean> = _progressBarIsEnabled

    fun setListNews(){
        viewModelScope.launch {
            _progressBarIsEnabled.postValue(true)
            val listNews: List<NewsModel> = interactor()
            if (listNews.isNotEmpty()){
                _news.postValue(listNews)
                _progressBarIsEnabled.postValue(false)
            }
        }
    }

}