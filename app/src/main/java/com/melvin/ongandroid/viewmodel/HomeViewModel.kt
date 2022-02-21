package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
<<<<<<< HEAD
import com.melvin.ongandroid.businesslogic.GetActivitiesInteractor
=======
import com.melvin.ongandroid.bussinesslogic.GetActivitiesInteractor

>>>>>>> main
import com.melvin.ongandroid.model.apimodel.ActivityModel
import kotlinx.coroutines.launch
import org.imaginativeworld.whynotimagecarousel.CarouselItem


class HomeViewModel : ViewModel() {
    private var getActivitiesInteractor = GetActivitiesInteractor()

<<<<<<< HEAD
    //variables livedata para cargar los datos en el carrousel de bienvenida
    //martin re
    private val _activities: MutableLiveData<List<CarouselItem>> = MutableLiveData()
    val activities: LiveData<List<CarouselItem>> = _activities
    //variables livedata para ocultar carousel en caso de que la lista de actividades
    //este vacia
    //martin re
    private val _carouselIsGone: MutableLiveData<Boolean> = MutableLiveData()
    val carouselIsgone: MutableLiveData<Boolean> = _carouselIsGone

=======
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

>>>>>>> main
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
}