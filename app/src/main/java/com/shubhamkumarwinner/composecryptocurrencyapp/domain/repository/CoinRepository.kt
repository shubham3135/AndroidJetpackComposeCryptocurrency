package com.shubhamkumarwinner.composecryptocurrencyapp.domain.repository

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}