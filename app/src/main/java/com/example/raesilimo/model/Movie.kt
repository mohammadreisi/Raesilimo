package com.example.raesilimo.model


import com.google.gson.annotations.SerializedName

/**This is main movie class that store data form server and exposes it to RealmMovie*/
data class Movie(
    @SerializedName("imdbID")
    var imdbID: String,
    @SerializedName("Poster")
    var poster: String,
    @SerializedName("Title")
    var title: String,
    @SerializedName("Type")
    var type: String,
    @SerializedName("Year")
    var year: String
)