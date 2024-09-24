package com.meianoitedev.carshop.home_feature.di

import com.meianoitedev.carshop.home_feature.domain.repository.CarsRepository
import com.meianoitedev.carshop.home_feature.domain.use_case.GetCarsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CarsUseCaseModule {

    @Provides
    fun provideGetCarUseCase(carsRepository: CarsRepository): GetCarsUseCase {
        return GetCarsUseCase(carsRepository)
    }

}
