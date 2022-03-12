package com.example.raesilimo.data.network

import com.example.raesilimo.model.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.raesilimo.model.MovieResponse

/**Basic interface Class for retrofit methods*/
interface RetrofitApiService {

    @GET(".")
    suspend fun getAllBatmanList(
        @Query("apikey") apiKey: String?,
        @Query("s") search: String?
    ): Response<MovieResponse>

    @GET(".")
    suspend fun getMovieDetail(
        @Query("apikey") apiKey: String?,
        @Query("i") movieId: String?
    ): Response<MovieDetails>
}