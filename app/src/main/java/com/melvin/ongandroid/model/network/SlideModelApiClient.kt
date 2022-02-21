package com.melvin.ongandroid.model.network

/**
 * Esta interface representa consulta a la api del proyecto
 * url: http://ongapi.alkemy.org/api/slides
 *
 * @author Martin Re
 */

import com.melvin.ongandroid.model.apimodel.SlideModelResponse
import com.melvin.ongandroid.model.apiservice.ApiConstants
import retrofit2.Response
import retrofit2.http.GET


/**
 * Metodo que devuelve una lista de Slides desde en el end point 'api/slides'
 */
interface SlideModelApiClient {
    @GET("ApiConstants.SLIDES_END_POINT")
    suspend fun getAllSlides(): Response<SlideModelResponse>

}