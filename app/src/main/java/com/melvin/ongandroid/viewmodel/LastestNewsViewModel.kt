package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.ViewModel
import org.imaginativeworld.whynotimagecarousel.CarouselItem
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 79ff99d8fe4a12b99706487cc06e7802c5d64b2c
=======
>>>>>>> 242e7239aabdb1dd26c2e781d3c43ec6aa0de220

class LastestNewsViewModel :ViewModel() {

    fun addItems(): List<CarouselItem>{

        val items = mutableListOf<CarouselItem>()

        items.add(CarouselItem("https://th.bing.com/th/id/OIP.7Zm8c0rmrGoURKXtK5KacwHaFj?w=225&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))
        items.add(CarouselItem("https://th.bing.com/th/id/OIP.MuZj_uk2byfZ0I36Mni-HgHaD4?w=322&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))
        items.add(CarouselItem("https://th.bing.com/th/id/OIP.TEbDh1Y0Zkh-PbGWC-mRrwHaD4?w=322&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))
        items.add(CarouselItem("https://th.bing.com/th/id/OIP.gVwjgA2MCF8t4RExmprOHwHaEG?w=325&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))

        return items
    }
}