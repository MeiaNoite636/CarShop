package com.meianoitedev.carshop.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meianoitedev.carshop.data.source.local.entity.CarEntity
import com.meianoitedev.carshop.util.Tables
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {

    @Query("SELECT * FROM ${Tables.CAR_TABLE}")
    fun getCars(): Flow<List<CarEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(carEntity: CarEntity)
}