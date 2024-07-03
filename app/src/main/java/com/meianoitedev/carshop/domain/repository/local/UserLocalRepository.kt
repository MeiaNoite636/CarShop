package com.meianoitedev.carshop.domain.repository.local

import com.meianoitedev.carshop.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserLocalRepository {

    fun getUsers(): Flow<UserEntity>
    suspend fun insertUser(userEntity: UserEntity)
}