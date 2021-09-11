package com.shubhamkumarwinner.composecryptocurrencyapp.data.remote

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}