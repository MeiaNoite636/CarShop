package com.meianoitedev.carshop.data.repository.local.order

import com.meianoitedev.carshop.data.source.local.dao.OrderDao
import com.meianoitedev.carshop.data.source.local.entity.OrderEntity
import com.meianoitedev.carshop.domain.repository.local.OrderLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderLocalRepositoryImpl @Inject constructor(
    private val orderDao: OrderDao
) : OrderLocalRepository {
    override fun getOrders(): Flow<List<OrderEntity>> {
        return orderDao.getOrders()
    }

    override suspend fun insertOrder(orderEntity: OrderEntity) {
        return orderDao.insertOrder(orderEntity)
    }

}