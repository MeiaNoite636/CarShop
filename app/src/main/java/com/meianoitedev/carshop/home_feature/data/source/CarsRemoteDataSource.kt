package com.meianoitedev.carshop.home_feature.data.source

import com.meianoitedev.carshop.home_feature.data.source.response.Car
import retrofit2.http.GET
import retrofit2.http.Path

interface CarsRemoteDataSource {

    @GET("cars.json")
    suspend fun getCars(): List<Car>

    @GET("cars/{id}.json")
    suspend fun getCarById(
        @Path("id") id: Int
    ): Car

//    @PUT("cars/leads")
//    suspend fun sendToLeads(@Path("id") id: Int, @Body car: Car)

}