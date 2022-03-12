package com.example.raesilimo.model


import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

/**This class is main model class that received from server and is contains of lists of
 * movies*/
open class MovieResponse (
    @SerializedName("Response")
    val response: String = "",
    @SerializedName("Search")
    val movies: List<Movie> = ArrayList<Movie>(),
    @SerializedName("totalResults")
    val totalResults: String = ""
)