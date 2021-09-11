package com.shubhamkumarwinner.composecryptocurrencyapp.domain.use_case.get_coin

import com.shubhamkumarwinner.composecryptocurrencyapp.data.remote.dto.toCoinDetail
import com.shubhamkumarwinner.composecryptocurrencyapp.domain.model.CoinDetail
import com.shubhamkumarwinner.composecryptocurrencyapp.domain.repository.CoinRepository
import com.shubhamkumarwinner.composecryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))

        }
    }
}