package com.example.raesilimo.data.repository

import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.data.network.NetworkResult
import com.example.raesilimo.model.Movie
import com.example.raesilimo.model.RealmMovie
import kotlinx.coroutines.flow.Flow

/**This is interface of app repository*/
interface IRepository {

    suspend fun getMoviesListFromServer(): NetworkResult<MovieResponse>

    suspend fun getMovieDetailsFromServer(movieId : String): Flow<NetworkResult<MovieDetails>>

    suspend fun getMoviesList(): Flow<List<RealmMovie>>
}