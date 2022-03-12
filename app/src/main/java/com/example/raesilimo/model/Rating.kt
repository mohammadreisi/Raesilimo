package com.example.raesilimo.model


import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

data class Rating(
    @SerializedName("Source")
    var source: String = "",
    @SerializedName("Value")
    var value: String = ""
)