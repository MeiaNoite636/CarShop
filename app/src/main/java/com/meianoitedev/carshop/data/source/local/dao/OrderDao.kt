package com.meianoitedev.carshop.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meianoitedev.carshop.data.source.local.entity.OrderEntity
import com.meianoitedev.carshop.util.Tables
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Query("SELECT * FROM ${Tables.ORDER_TABLE}")
    fun getOrders(): Flow<List<OrderEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderEntity: OrderEntity)
}