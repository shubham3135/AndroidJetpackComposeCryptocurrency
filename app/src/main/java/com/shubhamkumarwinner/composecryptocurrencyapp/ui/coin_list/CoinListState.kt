package com.shubhamkumarwinner.composecryptocurrencyapp.ui.coin_list

import com.shubhamkumarwinner.composecryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
