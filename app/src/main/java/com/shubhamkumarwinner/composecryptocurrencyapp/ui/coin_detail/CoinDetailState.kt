package com.shubhamkumarwinner.composecryptocurrencyapp.ui.coin_detail

import com.shubhamkumarwinner.composecryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
