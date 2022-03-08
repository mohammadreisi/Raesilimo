package com.example.raesilimo.repository

import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.repository.network.BaseApiResponse
import com.example.raesilimo.repository.network.NetworkResult
import com.example.raesilimo.repository.network.RetrofitApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(private val retrofitApiService: RetrofitApiService) :
    IRepository {

    override fun getMoviesList(): Flow<NetworkResult<MovieResponse>> {
        return flow {
            emit(BaseApiResponse().safeApiCall {
                retrofitApiService.getAllBatmanList("3e974fca", "batman")
            })
        }.flowOn(Dispatchers.IO)
    }

    override fun getMovieDetails(movieId : String): Flow<NetworkResult<MovieDetails>> {
        return flow {
            emit(BaseApiResponse().safeApiCall {
                retrofitApiService.getMovieDetail("3e974fca", movieId  )
            })
        } .flowOn(Dispatchers.IO)
    }

}