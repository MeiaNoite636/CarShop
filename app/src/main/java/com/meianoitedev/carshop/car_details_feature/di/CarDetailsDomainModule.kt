package com.meianoitedev.carshop.car_details_feature.di

import com.meianoitedev.carshop.car_details_feature.data.repository.CarDetailsRepositoryImpl
import com.meianoitedev.carshop.car_details_feature.domain.repository.CarDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CarDetailsDomainModule {

    @Binds
    abstract fun bindCarDetailsRepository(
        carDetailsRepositoryImpl: CarDetailsRepositoryImpl
    ): CarDetailsRepository

}