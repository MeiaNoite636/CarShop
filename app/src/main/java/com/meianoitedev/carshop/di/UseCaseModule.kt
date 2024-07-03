package com.meianoitedev.carshop.di

import com.meianoitedev.carshop.domain.repository.auth.FirebaseAuthRepository
import com.meianoitedev.carshop.domain.repository.car.CarRepository
import com.meianoitedev.carshop.domain.repository.local.CarLocalRepository
import com.meianoitedev.carshop.domain.usecase.auth.LoginUseCase
import com.meianoitedev.carshop.domain.usecase.auth.RecoverUseCase
import com.meianoitedev.carshop.domain.usecase.auth.RegisterUseCase
import com.meianoitedev.carshop.domain.usecase.car.GetCarUseCase
import com.meianoitedev.carshop.domain.usecase.local.car.GetCarsLocalUseCase
import com.meianoitedev.carshop.domain.usecase.local.car.InsertCarLocalUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCarUseCase(carRepository: CarRepository): GetCarUseCase {
        return GetCarUseCase(carRepository)
    }

    @Provides
    fun provideLoginUseCase(firebaseAuthRepository: FirebaseAuthRepository): LoginUseCase {
        return LoginUseCase(firebaseAuthRepository)
    }

    @Provides
    fun provideRecoverUseCase(firebaseAuthRepository: FirebaseAuthRepository): RecoverUseCase {
        return RecoverUseCase(firebaseAuthRepository)
    }

    @Provides
    fun provideRegisterUseCase(firebaseAuthRepository: FirebaseAuthRepository): RegisterUseCase {
        return RegisterUseCase(firebaseAuthRepository)
    }

    @Provides
    fun provideGetCarsLocalUseCase(carLocalRepository: CarLocalRepository): GetCarsLocalUseCase {
        return GetCarsLocalUseCase(carLocalRepository)
    }

    @Provides
    fun provideInsertCarLocalRepository(carLocalRepository: CarLocalRepository): InsertCarLocalUseCase {
        return InsertCarLocalUseCase(carLocalRepository)
    }



}
