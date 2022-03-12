package com.example.raesilimo.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.raesilimo.data.database.RealmDao
import com.example.raesilimo.data.repository.AppRepository
import com.example.raesilimo.data.repository.IRepository
import com.example.raesilimo.data.network.RetrofitApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import javax.inject.Singleton
import io.realm.RealmConfiguration


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(32)))
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

    @Singleton
    @Provides
    fun provideRealmDao(realm: Realm): RealmDao {
        return RealmDao(realm)
    }

    @Singleton
    @Provides
    fun provideIRepository(
        retrofitApiService: RetrofitApiService,
        realmDao: RealmDao
    ): IRepository {
        return AppRepository(retrofitApiService, realmDao)
    }

    @Singleton
    @Provides
    fun provideRealm(@ApplicationContext context: Context): Realm {
        Realm.init(context)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        Realm.compactRealm(config)
        return Realm.getDefaultInstance()
    }
}