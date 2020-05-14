package com.reactions.deathlines.mvvm.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.reactions.deathlines.data.db.MyDatabase
import com.reactions.deathlines.mvvm.di.qualifier.ApplicationContext
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideMyDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context, MyDatabase::class.java, "mydatabase")
            .build()

    @Singleton
    @Provides
    fun provideAlbumDao(myDatabase: MyDatabase) = myDatabase.albumDao()
}