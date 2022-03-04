package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.GetActivitiesInteractor
import com.melvin.ongandroid.model.apimodel.ActivityModel
import kotlinx.coroutines.launch
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class HomeViewModel : ViewModel() {

    private var getActivitiesInteractor = GetActivitiesInteractor()

    //variables livedata para cargar los datos en el carrousel de bienvenida
    //martin re
    private val _activities: MutableLiveData<List<CarouselItem>> = MutableLiveData()
    val activities: LiveData<List<CarouselItem>> = _activities
    //variables livedata para ocultar carousel en caso de que la lista de actividades
    //este vacia
    //martin re
    private val _carouselIsGone: MutableLiveData<Boolean> = MutableLiveData()
    val carouselIsgone: MutableLiveData<Boolean> = _carouselIsGone


    //metodo de creacion viewmodel, iniciar los metodos privados de viewmodel actual
    //martin re


    //metodo que obtiene la lista de actividades desde el interactor
    //martin re
    fun getListActivities(){

        viewModelScope.launch {
            val activitiesInteractor: List<ActivityModel> = getActivitiesInteractor()
            var carouselList = mutableListOf<CarouselItem>()
            if (activitiesInteractor.isNotEmpty()){
                for (activity in activitiesInteractor){
                    carouselList.add(CarouselItem(activity.image,
                        activity.name.uppercase() + "\n" + activity.description))
                }
                _activities.postValue(carouselList)
            }else{
                _carouselIsGone.postValue(true)
            }
        }
    }

    /*Agregado Provisional de items, para novedades, creado por Jose Luis Mora.
    Mauro Peña.***
     */

    fun addItems(): List<CarouselItem>{

        val items = mutableListOf<CarouselItem>()

        items.add(CarouselItem("https://th.bing.com/th/id/OIP.7Zm8c0rmrGoURKXtK5KacwHaFj?w=225&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))
        items.add(CarouselItem("https://th.bing.com/th/id/OIP.MuZj_uk2byfZ0I36Mni-HgHaD4?w=322&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))
        items.add(CarouselItem("https://th.bing.com/th/id/OIP.TEbDh1Y0Zkh-PbGWC-mRrwHaD4?w=322&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))
        items.add(CarouselItem("https://th.bing.com/th/id/OIP.gVwjgA2MCF8t4RExmprOHwHaEG?w=325&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7"))

        return items
    }
}