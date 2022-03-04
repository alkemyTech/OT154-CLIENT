package com.melvin.ongandroid.model.apiservice.network


import com.melvin.ongandroid.data.apiservice.RetrofitInstance
import com.melvin.ongandroid.model.apimodel.SlideModelResponse
import com.melvin.ongandroid.model.network.SlideModelApiClient


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response



/**
 * Clase que devuelve datos de tipo Slide desde api retrofit
 *
 * @author Martin Re
 */
class SlideModelService {

    private val retrofit = RetrofitInstance.retrofitBuilder()

    suspend fun getActivities():Response<SlideModelResponse>{
         return withContext(Dispatchers.IO){
            val response = retrofit.create(SlideModelApiClient::class.java).getAllSlides()
             response
        }

    }




}