package com.melvin.ongandroid.bussinesslogic

import com.melvin.ongandroid.model.apimodel.ActivityModel
import com.melvin.ongandroid.model.repository.ActivitiesRepository



/**
 * clase interactor obtiene desde repositorio
 * un response y devuelve una lista con las actividades realizadas por la ONG.
 *
 * @author Martin Re
 */
class GetActivitiesInteractor {

    private val repository = ActivitiesRepository()

    suspend operator fun invoke(): List<ActivityModel> {
        val listActivities = repository.getActivitiesFromApi()
        if (listActivities.isNullOrEmpty()){
            return emptyList()
        }else{
            return listActivities
        }
    }


}