package com.example.raesilimo.data.network

import com.example.raesilimo.model.MovieResponse
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

class BaseApiResponseTest {

    lateinit var baseApiResponse: BaseApiResponse

    @Mock
    lateinit var api: suspend () -> Response<MovieResponse>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        baseApiResponse = BaseApiResponse()
    }

    @Test
    fun returnSuccessNetworkResult_WithSuccessApiResponse() {



    }

}