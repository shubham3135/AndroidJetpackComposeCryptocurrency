package com.shubhamkumarwinner.composecryptocurrencyapp.di

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.CoinPaprikaApi
import com.shubhamkumarwinner.composecryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.shubhamkumarwinner.composecryptocurrencyapp.domain.repository.CoinRepository
import com.shubhamkumarwinner.composecryptocurrencyapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(CoinPaprikaApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi):CoinRepository = CoinRepositoryImpl(api)
}