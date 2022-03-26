package com.melvin.ongandroid.data.repository

import com.melvin.ongandroid.data.datasource.SlideDataSource
import com.melvin.ongandroid.data.datasource.SlideDataSourceImpl
import com.melvin.ongandroid.data.local.model.ActivityModel


/**
 * Esta clase obtiene un response de las actividades realizadas por la ONG.
 * Ya sea desde un repositorio remoto o local
 *
 * @author Martin Re
 */
class SlidesRepositoryImpl: SlidesRepository {

    private val dataSource: SlideDataSource = SlideDataSourceImpl()

    override suspend fun getActivitiesFromApi(): List<ActivityModel>? {
        val response = dataSource.getSlides()
        return if (response.code() == 200 && response.isSuccessful){
            response.body()?.data
        }else{
            emptyList()
        }

    }

}