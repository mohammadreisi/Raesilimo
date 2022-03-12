package com.example.raesilimo.ui.movies_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.data.repository.IRepository
import com.example.raesilimo.data.network.NetworkResult
import com.example.raesilimo.model.Movie
import com.example.raesilimo.model.RealmMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.Realm
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**This ListMovieFragment view model indicates movies in list and implements movie click
 * to showing it's details
 *
 * params:
 *      appRepository:
 *              this is instance of main repository that shared as singleton
 *              in all of app to truth accessibility to data source
 *              this dependency provides with dagger hilt*/
@HiltViewModel
class ListMoviesViewModel @Inject constructor(private val appRepository: IRepository) : ViewModel() {

    var moviesListCallResult: MutableLiveData<List<RealmMovie>> = MutableLiveData()

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