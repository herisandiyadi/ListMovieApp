package com.herisand.submissionjp.datafile.source.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.herisand.submissionjp.datafile.source.local.entity.MovieEntity
import com.herisand.submissionjp.datafile.source.local.entity.TvEntity


@Database(
    entities = [MovieEntity::class, TvEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ContentDatabase: RoomDatabase() {

    abstract fun contentDao(): ContentDAO

    companion object {

        @Volatile
        private var INSTANCE : ContentDatabase? = null

        fun getInstance(context: Context): ContentDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ContentDatabase::class.java,
                    "Content.db"
                ).build()
            }
    }
}