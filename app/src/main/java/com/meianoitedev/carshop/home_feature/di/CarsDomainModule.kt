package com.meianoitedev.carshop.home_feature.di

import com.meianoitedev.carshop.home_feature.data.repository.CarsRepositoryImpl
import com.meianoitedev.carshop.home_feature.domain.repository.CarsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CarsDomainModule {

    @Binds
    abstract fun bindCarRepository(
        carsRepositoryImpl: CarsRepositoryImpl
    ): CarsRepository

}