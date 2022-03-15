package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.local.model.ActivityModel


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