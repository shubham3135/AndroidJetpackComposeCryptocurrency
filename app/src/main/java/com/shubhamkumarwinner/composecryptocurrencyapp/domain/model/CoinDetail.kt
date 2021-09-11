package com.shubhamkumarwinner.composecryptocurrencyapp.domain.model

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.TeamMember
import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.Whitepaper

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String?,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)
