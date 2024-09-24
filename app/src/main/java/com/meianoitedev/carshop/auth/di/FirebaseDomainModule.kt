package com.meianoitedev.carshop.auth.di

import com.meianoitedev.carshop.auth.data.repository.FirebaseAuthRepositoryImpl
import com.meianoitedev.carshop.auth.domain.repository.FirebaseAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseDomainModule {

    @Binds
    abstract fun bindFirebaseAuthRepository(
        firebaseAuthRepositoryImpl: FirebaseAuthRepositoryImpl
    ): FirebaseAuthRepository

}