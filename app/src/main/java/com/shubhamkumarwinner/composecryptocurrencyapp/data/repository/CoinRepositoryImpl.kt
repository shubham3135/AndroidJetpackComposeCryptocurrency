package com.shubhamkumarwinner.composecryptocurrencyapp.data.repository

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.CoinPaprikaApi
import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.CoinDto
import com.shubhamkumarwinner.composecryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}