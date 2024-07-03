package com.meianoitedev.carshop.di


import android.content.Context
import androidx.room.Room
import com.meianoitedev.carshop.data.source.local.dao.CarDao
import com.meianoitedev.carshop.data.source.local.dao.OrderDao
import com.meianoitedev.carshop.data.source.local.dao.UserDao
import com.meianoitedev.carshop.data.source.local.db.AppDatabase
import com.meianoitedev.carshop.util.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun providesDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context = context,
        klass = AppDatabase::class.java,
        name = Database.DATABASE
    ).build()

    @Provides
    fun providesCarDao(database: AppDatabase): CarDao = database.carDao()

    @Provides
    fun providesUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    fun providesOrderDao(database: AppDatabase): OrderDao = database.orderDao()
}