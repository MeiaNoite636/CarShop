package com.meianoitedev.carshop.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meianoitedev.carshop.data.source.local.entity.UserEntity
import com.meianoitedev.carshop.util.Tables
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM ${Tables.USER_TABLE}")
    fun getUsers(): Flow<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)
}