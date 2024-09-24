package com.meianoitedev.carshop.auth.di

import com.meianoitedev.carshop.auth.domain.repository.FirebaseAuthRepository
import com.meianoitedev.carshop.auth.domain.use_case.LoginUseCase
import com.meianoitedev.carshop.auth.domain.use_case.RecoverUseCase
import com.meianoitedev.carshop.auth.domain.use_case.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class FirebaseUseCaseModule {

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

}