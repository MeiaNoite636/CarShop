package com.meianoitedev.carshop.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meianoitedev.carshop.data.source.local.dao.CarDao
import com.meianoitedev.carshop.data.source.local.dao.OrderDao
import com.meianoitedev.carshop.data.source.local.dao.UserDao
import com.meianoitedev.carshop.data.source.local.entity.CarEntity
import com.meianoitedev.carshop.data.source.local.entity.OrderEntity
import com.meianoitedev.carshop.data.source.local.entity.UserEntity

@Database(entities = [CarEntity::class, OrderEntity::class, UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao

    abstract fun orderDao(): OrderDao

    abstract fun userDao(): UserDao
}