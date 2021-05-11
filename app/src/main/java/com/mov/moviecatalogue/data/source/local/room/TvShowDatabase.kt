package com.mov.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mov.moviecatalogue.data.model.MovieEntity
import com.mov.moviecatalogue.data.model.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 2, exportSchema = false)
abstract class TvShowDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvshowDao(): TvShowDao

    companion object {
        private var INSTANCE: TvShowDatabase? = null

        fun getInstance(context: Context): TvShowDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    TvShowDatabase::class.java,
                    "tvshows.db"
                ).allowMainThreadQueries()
                    .build().apply {
                        INSTANCE = this
                    }
            }
    }
}