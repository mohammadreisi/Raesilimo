package com.example.raesilimo.ui.movie_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raesilimo.model.MovieDetails
import com.example.raesilimo.repository.AppRepository
import com.example.raesilimo.repository.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsMovieViewModel @Inject constructor(private val appRepository: AppRepository) :
    ViewModel() {

    var movieDetailsResponse: MutableLiveData<NetworkResult<MovieDetails>> = MutableLiveData()

    fun getMovieDetails(movieId : String) {
        viewModelScope.launch {
            appRepository.getMovieDetails(movieId).collect {
                movieDetailsResponse.value = it
            }
        }

    }
}