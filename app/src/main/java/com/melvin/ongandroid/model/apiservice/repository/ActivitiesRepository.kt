package com.melvin.ongandroid.model.repository



import com.melvin.ongandroid.model.apimodel.ActivityModel
import com.melvin.ongandroid.model.network.SlideModelService



/**
 * Esta clase obtiene un response de las actividades realizadas por la ONG.
 * Ya sea desde un repositorio remoto o local
 *
 * @author Martin Re
 */
class ActivitiesRepository {

    private val apiService = SlideModelService()

    suspend fun getActivitiesFromApi(): List<ActivityModel>? {
        val response = apiService.getActivities()
        if (response.isSuccessful){
            return response.body()?.data
        }else{
            return emptyList()
        }

    }

}