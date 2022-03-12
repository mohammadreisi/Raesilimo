package com.example.raesilimo.data.database

import android.util.Log
import com.example.raesilimo.model.Movie
import com.example.raesilimo.model.RealmMovie
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.executeTransactionAwait
import javax.inject.Inject
import io.realm.mongodb.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable.isActive

/**A intermediary class for accessibility to realm database transaction
 *
 * params:
 *          realm: An instance of realm database for transaction that provides
 *          with dagger hilt*/

class RealmDao @Inject constructor(val realm: Realm) {

    suspend fun saveMovie(movie: Movie) {

        realm.executeTransactionAwait(Dispatchers.IO)  { realm1 ->
            val realmMovieObject =
                RealmMovie(movie.imdbID, movie.poster, movie.title, movie.type, movie.year)
            realm1.copyToRealmOrUpdate(realmMovieObject)
        }

    }

/*
    fun updateMove(movie: Movie) {
        realm.executeTransaction(Realm.Transaction { realm ->
            realm.copyToRealmOrUpdate(movie)
        })
    }
*/

    fun getAllMovies(): RealmResults<RealmMovie> {
        var realmResults = realm.where(RealmMovie::class.java).findAll()
        return realmResults
    }

}