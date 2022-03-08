package com.example.raesilimo.ui.movies_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.repository.IRepository
import com.example.raesilimo.repository.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListMoviesViewModel @Inject constructor(private val appRepository: IRepository) : ViewModel() {

    var moviesListCallResult: MutableLiveData<NetworkResult<MovieResponse>> = MutableLiveData()

    init {
        getMoviesList()
    }

    @JvmName("getMoviesList1")
    fun getMoviesList() {
        viewModelScope.launch {
            appRepository.getMoviesList().collect {
                moviesListCallResult.value = it
            }
        }
    }

}