package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Testimonial
import com.melvin.ongandroid.model.activity.Activity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import com.melvin.ongandroid.model.apiservice.apimodel.NewUserResponse
import retrofit2.http.*


interface APIService {
    //Tomamos informacion desde testimonios en la API - Leandro Valderas
    @GET( "api/testimonials")
    suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>>

    //Tomamos informacion desde activities en la API - Leandro Valderas
    @GET( "api/activities")
    suspend fun getActivities(): ResponseApi<MutableList<Activity>>

    @FormUrlEncoded
    @POST("api/register")

    fun postNewUser(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("password") password: String
    ): Call<NewUserResponse>
}