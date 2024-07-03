package com.meianoitedev.carshop.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meianoitedev.carshop.util.ColumnsOrder
import com.meianoitedev.carshop.util.Tables

@Entity(tableName = Tables.ORDER_TABLE)
data class OrderEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo(name = ColumnsOrder.USER_ID_COLUMN)
    val userIdTable: Int,

    @ColumnInfo(name = ColumnsOrder.USER_NAME_COLUMN)
    val userName: String,

    @ColumnInfo(name = ColumnsOrder.USER_EMAIL_COLUMN)
    val userEmail: String,

    @ColumnInfo(name = ColumnsOrder.CAR_ID_COLUMN)
    val carIdTable: Int,

    @ColumnInfo(name = ColumnsOrder.CAR_YEAR_COLUMN)
    val carYear: Int,

    @ColumnInfo(name = ColumnsOrder.CAR_COLOR_COLUMN)
    val carColor: String,

    @ColumnInfo(name = ColumnsOrder.CAR_FUEL_COLUMN)
    val carFuel: String,

    @ColumnInfo(name = ColumnsOrder.CAR_ID_CAR_COLUMN)
    val carIdCar: Int,

    @ColumnInfo(name = ColumnsOrder.CAR_MODEL_NAME_COLUMN)
    val carModelName: String,

    @ColumnInfo(name = ColumnsOrder.CAR_DOORS_NUMBER_COLUMN)
    val carDoorsNumber: Int,

    @ColumnInfo(name = ColumnsOrder.CAR_REGISTER_TIMESTAMP_COLUMN)
    val carRegisterTimestamp: Long,

    @ColumnInfo(name = ColumnsOrder.CAR_PRICE_COLUMN)
    val carPrice: Double,
)