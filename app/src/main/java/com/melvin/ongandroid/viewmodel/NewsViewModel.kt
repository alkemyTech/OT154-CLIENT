package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.model.apiservice.NewsResponse

class NewsViewModel: ViewModel() {
    fun addItems(): MutableList<NewsResponse>{
        val news = mutableListOf<NewsResponse>()

        news.add(NewsResponse(0,"Hola","asdasdasdas","https://cdn.pixabay.com/photo/2020/06/01/22/23/eyes-5248678_960_720.jpg",""))
        news.add(NewsResponse(1,"Que tal","asdadasdga","https://cdn.pixabay.com/photo/2020/05/24/23/44/hands-5216585_960_720.jpg",""))
        news.add(NewsResponse(2,"Como estan","ghhadas","https://cdn.pixabay.com/photo/2019/03/18/04/53/bird-4062359_960_720.jpg",""))

        return news
    }

}