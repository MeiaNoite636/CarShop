package com.meianoitedev.carshop.home_feature.data.source.mapper

import com.meianoitedev.carshop.car_details_feature.domain.model.CarDetailsPresentation
import com.meianoitedev.carshop.home_feature.data.source.response.Car
import com.meianoitedev.carshop.home_feature.domain.model.CarPresentation

fun Car.toCarPresentation(): CarPresentation {
    return CarPresentation(
        year = year,
        fuel = fuel,
        id = id,
        modelName = modelName,
        price = price
    )
}

fun Car.toCarDetailsPresentation(): CarDetailsPresentation {
    return CarDetailsPresentation(
        year = year,
        fuel = fuel,
        id = id,
        modelName = modelName,
        price = price,
        doorsNumber = doorsNumber,
        registerTimestamp = registerTimestamp,
        color = color
    )
}