package com.melvin.ongandroid.data.repository



import com.melvin.ongandroid.data.local.model.ActivityModel
import com.melvin.ongandroid.data.remote.network.SlideModelService



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
        return if (response.code() == 200 && response.isSuccessful){
            response.body()?.data
        }else{
            emptyList()
        }

    }

}