package com.meianoitedev.carshop.di

import com.meianoitedev.carshop.data.repository.remote.auth.FirebaseAuthRepositoryImpl
import com.meianoitedev.carshop.data.repository.remote.car.CarRemoteRepositoryImpl
import com.meianoitedev.carshop.data.repository.local.car.CarLocalRepositoryImpl
import com.meianoitedev.carshop.data.repository.local.order.OrderLocalRepositoryImpl
import com.meianoitedev.carshop.data.repository.local.user.UserLocalRepositoryImpl
import com.meianoitedev.carshop.domain.repository.auth.FirebaseAuthRepository
import com.meianoitedev.carshop.domain.repository.car.CarRepository
import com.meianoitedev.carshop.domain.repository.local.CarLocalRepository
import com.meianoitedev.carshop.domain.repository.local.OrderLocalRepository
import com.meianoitedev.carshop.domain.repository.local.UserLocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindCarRepository(
        carRemoteRepositoryImpl: CarRemoteRepositoryImpl
    ): CarRepository

    @Binds
    abstract fun bindFirebaseAuthRepository(
        firebaseAuthRepositoryImpl: FirebaseAuthRepositoryImpl
    ): FirebaseAuthRepository

    @Binds
    abstract fun bindUserLocalRepository(
        userLocalRepositoryImpl: UserLocalRepositoryImpl
    ): UserLocalRepository

    @Binds
    abstract fun bindCarLocalRepository(
        carLocalRepositoryImpl: CarLocalRepositoryImpl
    ): CarLocalRepository

    @Binds
    abstract fun bindOrderLocalRepository(
        orderLocalRepositoryImpl: OrderLocalRepositoryImpl
    ): OrderLocalRepository


}