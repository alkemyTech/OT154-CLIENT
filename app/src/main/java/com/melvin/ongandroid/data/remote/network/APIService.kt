package com.melvin.ongandroid.data.remote.network

import com.melvin.ongandroid.data.remote.response.ResponseApi
import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.data.local.model.Testimonial
import com.melvin.ongandroid.data.remote.response.SlideModelResponse
import com.melvin.ongandroid.data.remote.response.NewsResponse
import retrofit2.Response
import com.melvin.ongandroid.data.local.model.Activity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import com.melvin.ongandroid.data.local.model.login.LoginModel
import com.melvin.ongandroid.data.remote.response.NewUserResponse
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

    //obtenemos lista de slides desde api - Martin Re
    @GET("api/slides")
    suspend fun getAllSlides(): Response<SlideModelResponse>

    //obtenemos lista de novedades desde api - Martin Re
    @GET("api/news")
    suspend fun getAllNews(): Response<NewsResponse>

    @FormUrlEncoded
    @POST("api/login")
    suspend fun login(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): LoginModel

    @POST("api/contacts")
    suspend fun saveContact(@Body contact: Contact): ResponseApi<Contact>

}