package com.shubhamkumarwinner.composecryptocurrencyapp.domain.use_case.get_coins

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.toCoin
import com.shubhamkumarwinner.composecryptocurrencyapp.domain.model.Coin
import com.shubhamkumarwinner.composecryptocurrencyapp.domain.repository.CoinRepository
import com.shubhamkumarwinner.composecryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e:HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage?:"An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))

        }
    }
}