package com.meianoitedev.carshop.home_feature.data.source.response


import com.google.gson.annotations.SerializedName

data class CarResponse(
    @SerializedName("cars")
    val cars: List<Car>
)