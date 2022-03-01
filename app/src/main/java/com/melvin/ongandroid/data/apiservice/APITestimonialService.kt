package com.melvin.ongandroid.data.apiservice

import com.melvin.ongandroid.data.response.ResponseApi
import com.melvin.ongandroid.model.Contact
import com.melvin.ongandroid.model.Testimonial
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

<<<<<<< HEAD:app/src/main/java/com/melvin/ongandroid/data/apiservice/APITestimonialService.kt
interface APITestimonialService {
=======
interface APIService {
>>>>>>> 4e97604a202a9875838e160841d420f585ca6376:app/src/main/java/com/melvin/ongandroid/data/apiservice/APIService.kt
    //Tomamos informacion desde testimonios en la API - Leandro Valderas
    @GET( "api/testimonials")
    suspend fun getTestimonials(): ResponseApi<MutableList<Testimonial>>

    @POST("api/contacts")
    suspend fun postContacts(@Body contactData: Contact): Call<Contact>

}