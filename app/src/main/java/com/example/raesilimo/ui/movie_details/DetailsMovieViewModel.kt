package com.example.raesilimo.ui.movie_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.data.repository.AppRepository
import com.example.raesilimo.data.network.NetworkResult
import com.example.raesilimo.data.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**This DetailsMovieFragment view model indicates movies in list and implements movie click
 * to showing it's details
 *
 * params:
 *      appRepository:
 *              this is instance of main repository that shared as singleton
 *              in all of app to truth accessibility to data source
 *              this dependency provides with dagger hilt*/
@HiltViewModel
class DetailsMovieViewModel @Inject constructor(private val appRepository: IRepository) :
    ViewModel() {

    var movieDetailsResponse: MutableLiveData<NetworkResult<MovieDetails>> = MutableLiveData()

//    @InternalCoroutinesApi
//    fun getMovieDetails(movieId: String) {
//        viewModelScope.launch {
//            appRepository.getMovieDetailsFromServer(movieId).collect{}
//        }
//    }

    @InternalCoroutinesApi
    fun getMovieDetails(movieId: String) {
        viewModelScope.launch {
            appRepository.getMovieDetailsFromServer(movieId)
                .collect { movieDetailsResponse.value = it }
        }

    }


}