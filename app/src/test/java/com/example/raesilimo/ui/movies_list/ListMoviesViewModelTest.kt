package com.example.raesilimo.ui.movies_list

import androidx.lifecycle.MutableLiveData
import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.data.repository.FakeRepository
import com.example.raesilimo.data.network.NetworkResult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ListMoviesViewModelTest {
    lateinit var fakeRepository: FakeRepository


    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getMoviesListSuccessfully() = runBlocking {
        fakeRepository.getMoviesListFromServer().collect {
            assertTrue(it != null)
        }
    }

    @Test
    fun setLiveDataSuccessfully() = runBlocking {
        var networkResultLiveData = MutableLiveData<NetworkResult<MovieResponse>>()
        fakeRepository.getMoviesListFromServer().collect {
            networkResultLiveData.value = it
        }
        assertTrue(networkResultLiveData.value?.data != null)
    }
}