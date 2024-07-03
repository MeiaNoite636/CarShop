package com.meianoitedev.carshop.util


object Database{
    const val DATABASE = "LOCAL_DATABASE"
}

object Tables{
    const val USER_TABLE = "user_table"
    const val CAR_TABLE = "car_table"
    const val ORDER_TABLE = "order_table"
}

object ColumnsUser{
    const val USER_NAME_COLUMN = "name"
    const val USER_EMAIL_COLUMN = "email"
}

object ColumnsCar {
    const val CAR_YEAR_COLUMN = "year"
    const val CAR_COLOR_COLUMN = "color"
    const val CAR_FUEL_COLUMN = "fuel"
    const val CAR_ID_CAR_COLUMN = "id_car"
    const val CAR_MODEL_NAME_COLUMN = "model_name"
    const val CAR_DOORS_NUMBER_COLUMN = "doors_number"
    const val CAR_REGISTER_TIMESTAMP_COLUMN = "register_timestamp"
    const val CAR_PRICE_COLUMN = "price"

}

object ColumnsOrder{
    const val ORDER_ID_COLUMN = "id"
    const val USER_ID_COLUMN = "id_user"
    const val USER_NAME_COLUMN = "name_user"
    const val USER_EMAIL_COLUMN = "email_user"
    const val CAR_ID_COLUMN = "id_car"
    const val CAR_YEAR_COLUMN = "name_car"
    const val CAR_COLOR_COLUMN = "color_car"
    const val CAR_FUEL_COLUMN = "fuel_car"
    const val CAR_ID_CAR_COLUMN = "car_id_car"
    const val CAR_MODEL_NAME_COLUMN = "model_name_car"
    const val CAR_DOORS_NUMBER_COLUMN = "doors_number_car"
    const val CAR_REGISTER_TIMESTAMP_COLUMN = "timestamp_car"
    const val CAR_PRICE_COLUMN = "price_car"
}