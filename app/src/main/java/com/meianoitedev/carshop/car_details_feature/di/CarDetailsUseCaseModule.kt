package com.meianoitedev.carshop.car_details_feature.di

import com.meianoitedev.carshop.car_details_feature.domain.repository.CarDetailsRepository
import com.meianoitedev.carshop.car_details_feature.domain.usecase.GetCarDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CarDetailsUseCaseModule {

    @Provides
    fun provideGetCarDetailsUseCase(
        carDetailsRepository: CarDetailsRepository
    ): GetCarDetailsUseCase {
        return GetCarDetailsUseCase(carDetailsRepository)
    }
}