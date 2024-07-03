package com.meianoitedev.carshop.data.source.remote.response


import com.google.gson.annotations.SerializedName
import com.meianoitedev.carshop.data.source.remote.model.Car

data class CarResponse(
    @SerializedName("cars")
    val cars: List<Car>
)