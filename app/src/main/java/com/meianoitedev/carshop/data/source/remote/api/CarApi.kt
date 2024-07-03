package com.meianoitedev.carshop.data.source.remote.api

import com.meianoitedev.carshop.data.source.remote.response.CarResponse
import retrofit2.http.GET

interface CarApi {

    @GET("cars.json")
    suspend fun getCars(): CarResponse

}