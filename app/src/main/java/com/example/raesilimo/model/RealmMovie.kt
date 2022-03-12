package com.example.raesilimo.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**Data class(Entity) for store to realm data base with
 * PrimaryKey*/
open class RealmMovie(
    @PrimaryKey
    var imdbID: String = "",
    var poster: String = "",
    var title: String = "",
    var type: String = "",
    var year: String = ""
) : RealmObject()