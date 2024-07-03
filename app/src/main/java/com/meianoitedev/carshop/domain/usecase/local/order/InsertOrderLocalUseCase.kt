package com.meianoitedev.carshop.domain.usecase.local.order

import com.meianoitedev.carshop.data.source.local.entity.OrderEntity
import com.meianoitedev.carshop.domain.repository.local.OrderLocalRepository
import javax.inject.Inject

class InsertOrderLocalUseCase @Inject constructor(
    private val orderLocalRepository: OrderLocalRepository
) {
    suspend operator fun invoke(orderEntity: OrderEntity) {
        return orderLocalRepository.insertOrder(orderEntity)
    }
}