package com.meianoitedev.carshop.domain.repository.local

import com.meianoitedev.carshop.data.source.local.entity.OrderEntity
import kotlinx.coroutines.flow.Flow

interface OrderLocalRepository {
    fun getOrders(): Flow<List<OrderEntity>>

    suspend fun insertOrder(orderEntity: OrderEntity)
}