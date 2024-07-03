package com.meianoitedev.carshop.data.source.remote.mapper

import com.meianoitedev.carshop.data.source.remote.model.Car
import com.meianoitedev.carshop.data.source.remote.response.CarResponse
import com.meianoitedev.carshop.domain.model.CarPresentation

fun Car.toDomain(): CarPresentation {
    return CarPresentation(
        year = year,
        fuel = fuel,
        color = color,
        id = id,
        modelName = modelName,
        doorsNumber = doorsNumber,
        registerTimestamp = registerTimestamp,
        price = price
    )
}

fun CarResponse.toDomain(): List<CarPresentation> {
    return cars.map { it.toDomain() }
}