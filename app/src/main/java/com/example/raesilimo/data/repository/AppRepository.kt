package com.example.raesilimo.data.repository

import android.util.Log
import com.example.raesilimo.data.database.RealmDao
import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.data.network.BaseApiResponse
import com.example.raesilimo.data.network.NetworkResult
import com.example.raesilimo.data.network.RetrofitApiService
import com.example.raesilimo.model.Movie
import com.example.raesilimo.model.RealmMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

/** This is main class to access any data form database or server
 * this class shared as singleton in app entirely to provide truth data source
 * object to all classes
 *  Accessing to server data and data in realm database, do through this class
 *
 *  params:
 *           retrofitApiService:
 *              an instance of RetrofitApiService to access
 *              main retrofit methods
 *           realmDao:
 *              an instance of RealmDao to access realm database method
 *
 * input params of this class provides by dagger hilt
 * */

class AppRepository @Inject constructor(
    private val retrofitApiService: RetrofitApiService,
    private val realmDao: RealmDao
) :
    IRepository {

    override suspend fun getMoviesListFromServer(): NetworkResult<MovieResponse> {
        return BaseApiResponse().safeApiCall {
            retrofitApiService.getAllBatmanList("3e974fca", "batman")
        }
    }

    override suspend fun getMovieDetailsFromServer(movieId: String): Flow<NetworkResult<MovieDetails>> {
        return flow {
            emit(BaseApiResponse().safeApiCall {
                retrofitApiService.getMovieDetail("3e974fca", movieId)
            })
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getMoviesList(): Flow<List<RealmMovie>> {

        var networkResult = getMoviesListFromServer()

        if (saveInputServerDataToRealm(networkResult)) {
            return flow {
                emit(realmDao.getAllMovies())
            }.flowOn(Dispatchers.Main)
        } else {
            return flow {
                emit(realmDao.getAllMovies())
            }.flowOn(Dispatchers.Main)
        }
    }

    private suspend fun saveInputServerDataToRealm(networkResult: NetworkResult<MovieResponse>): Boolean {
        when (networkResult) {
            is NetworkResult.Success -> {
                for (i in 0..(networkResult.data?.movies?.size!!)) {
                    networkResult.data.movies.get(i).let {
                        try {
                            realmDao.saveMovie(it)

                        }catch (e:Exception){
                            Log.i("AppRepository", "saveInputServerDataToRealm: "+e.message)
                        }
                    }
                }
                return true
            }
            is NetworkResult.Error -> {
                // show error message
            }
            is NetworkResult.Loading -> {
                // show a progress bar
            }
        }
        return false
    }

}