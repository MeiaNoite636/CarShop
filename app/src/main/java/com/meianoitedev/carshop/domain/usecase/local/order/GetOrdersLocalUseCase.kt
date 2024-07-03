package com.meianoitedev.carshop.domain.usecase.local.order

import com.meianoitedev.carshop.domain.repository.local.OrderLocalRepository
import javax.inject.Inject

class GetOrdersLocalUseCase @Inject constructor(
    private val orderLocalRepository: OrderLocalRepository
) {
    operator fun invoke() = orderLocalRepository.getOrders()
}