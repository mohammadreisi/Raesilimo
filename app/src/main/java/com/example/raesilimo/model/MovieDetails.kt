package com.example.raesilimo.model


import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

/**Data class for movie details associated to retrofit api service that
 * fill by server with getMovieDetail request in RetrofitApiService  */
data class MovieDetails(
    @SerializedName("Actors")
    var actors: String = "",
    @SerializedName("Awards")
    var awards: String = "",
    @SerializedName("Country")
    var country: String = "",
    @SerializedName("Director")
    var director: String = "",
    @SerializedName("Genre")
    var genre: String = "",
    @SerializedName("imdbID")
    @PrimaryKey
    var imdbID: String = "",
    @SerializedName("imdbRating")
    var imdbRating: String = "",
    @SerializedName("imdbVotes")
    var imdbVotes: String = "",
    @SerializedName("Language")
    var language: String = "",
    @SerializedName("Metascore")
    var metascore: String = "",
    @SerializedName("Plot")
    var plot: String = "",
    @SerializedName("Poster")
    var poster: String = "",
    @SerializedName("Rated")
    var rated: String = "",
    @SerializedName("Ratings")
    var ratings: List<Rating>? = null,
    @SerializedName("Released")
    var released: String = "",
    @SerializedName("Response")
    var response: String = "",
    @SerializedName("Runtime")
    var runtime: String = "",
    @SerializedName("Title")
    var title: String = "",
    @SerializedName("totalSeasons")
    var totalSeasons: String = "",
    @SerializedName("Type")
    var type: String = "",
    @SerializedName("Writer")
    var writer: String = "",
    @SerializedName("Year")
    var year: String = ""
) : Serializable