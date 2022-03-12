package com.example.raesilimo.data.network

import com.example.raesilimo.model.MovieResponse
import com.example.raesilimo.model.Movie

class DummyNetworkResultInstance {

    companion object {

        val searchList = arrayListOf(
            Movie(
                "tt0372784",
                "https://m.media-amazon.com/images/M/MV5BOTY4YjI2N2MtYmFlMC00ZjcyLTg3YjEtMDQyM2ZjYzQ5YWFkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg",
                "Batman Begins",
                "movie",
                "2005"
            ),
            Movie(
                "tt1569923",
                "https://m.media-amazon.com/images/M/MV5BNmY4ZDZjY2UtOWFiYy00MjhjLThmMjctOTQ2NjYxZGRjYmNlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg",
                "Batman: Under the Red Hood",
                "movie",
                "2010"
            )

        )
        val movieResponse = MovieResponse("true", searchList, "497")


        fun getSuccessNetworkResultInstance(): NetworkResult<MovieResponse> {
            return NetworkResult.Success(movieResponse)
        }

        fun getFailedNetworkResultInstance(): NetworkResult<MovieResponse> {
            return NetworkResult.Error("request failed")
        }

    }


}