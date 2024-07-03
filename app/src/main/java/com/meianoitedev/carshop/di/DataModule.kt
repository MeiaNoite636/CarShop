package com.meianoitedev.carshop.di

import com.meianoitedev.carshop.data.source.remote.api.CarApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideCarApi(
        retrofit: Retrofit
    ): CarApi {
        return retrofit.create(CarApi::class.java)
    }
}