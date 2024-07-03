package com.meianoitedev.carshop.data.repository.local.user

import com.meianoitedev.carshop.data.source.local.dao.UserDao
import com.meianoitedev.carshop.data.source.local.entity.UserEntity
import com.meianoitedev.carshop.domain.repository.local.UserLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLocalRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserLocalRepository {
    override fun getUsers(): Flow<UserEntity> {
        return userDao.getUsers()
    }

    override suspend fun insertUser(userEntity: UserEntity) {
        return userDao.insertUser(userEntity)
    }
}