package com.example.raesilimo.repository

import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.repository.network.NetworkResult
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getMoviesList(): Flow<NetworkResult<MovieResponse>>

    fun getMovieDetails(movieId : String): Flow<NetworkResult<MovieDetails>>
}