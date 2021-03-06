package com.example.watermyplants.api

import com.example.watermyplants.models.*
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

interface ApiCrud{

    // User
    @POST("user/register")
    fun register(@Body user: EditUser): Observable<User>

    @POST("user/login")
    fun login(@Body user: User): Observable<UserToken>

    @GET("user/single_user")
    fun currentUser(@Header("Authorization") token: String): Flowable<User>

    @PUT("user")
    fun updateInfo(@Header("Authorization") token: String, @Body user: EditUser): Observable<Int>

    // Plant
    @GET("plants")
    fun getPlants(@Header("Authorization") token: String): Flowable<List<Plant>>

    @POST("plants")
    fun createPlant(@Header("Authorization") token: String, @Body plant: EditPlant): Observable<Plant>

    @HTTP(method = "DELETE", path = "plants", hasBody = true)
    fun deletePlant(@Header("Authorization") token: String, @Body plant: Plant): Observable<Plant>

    @PUT("plants")
    fun updatePlant(@Header("Authorization") token: String, @Body plant: Plant): Observable<Int>

}
