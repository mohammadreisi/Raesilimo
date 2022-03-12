package com.example.raesilimo.data.repository

import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.data.network.DummyNetworkResultInstance
import com.example.raesilimo.data.network.NetworkResult
import com.example.raesilimo.model.RealmMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FakeRepository : IRepository{
    override suspend fun getMoviesListFromServer(): NetworkResult<MovieResponse> {
        TODO("Not yet implemented")
    }

//    override suspend fun getMoviesListFromServer(): Flow<NetworkResult<MovieResponse>> {
//
//        return flow {
//            emit(DummyNetworkResultInstance.getSuccessNetworkResultInstance())
//        }.flowOn(Dispatchers.IO)
//
//    }

    override suspend fun getMovieDetailsFromServer(movieId: String): Flow<NetworkResult<MovieDetails>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMoviesList(): Flow<List<RealmMovie>> {
        TODO("Not yet implemented")
    }

}