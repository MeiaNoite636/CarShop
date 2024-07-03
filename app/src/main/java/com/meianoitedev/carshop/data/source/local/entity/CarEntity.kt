package com.meianoitedev.carshop.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meianoitedev.carshop.util.ColumnsCar
import com.meianoitedev.carshop.util.Tables

@Entity(tableName = Tables.CAR_TABLE)
data class CarEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,

    @ColumnInfo(name = ColumnsCar.CAR_ID_CAR_COLUMN)
    val idCar: String?,

    @ColumnInfo(name = ColumnsCar.CAR_FUEL_COLUMN)
    val fuel: String?,

    @ColumnInfo(name = ColumnsCar.CAR_YEAR_COLUMN)
    val year: Int?,

    @ColumnInfo(name = ColumnsCar.CAR_COLOR_COLUMN)
    val color: Long?,

    @ColumnInfo(name = ColumnsCar.CAR_REGISTER_TIMESTAMP_COLUMN)
    val timeStamp: Long?,

    @ColumnInfo(name = ColumnsCar.CAR_MODEL_NAME_COLUMN)
    val modelName: Long?,

    @ColumnInfo(name = ColumnsCar.CAR_DOORS_NUMBER_COLUMN)
    val doorsNumber: Long?,

    @ColumnInfo(name = ColumnsCar.CAR_PRICE_COLUMN)
    val price: Long

)