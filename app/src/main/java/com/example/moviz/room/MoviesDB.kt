package com.example.moviz.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviz.retrofit.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(Converters::class)
abstract class MoviesDB : RoomDatabase() {

    // DAO
    abstract val moviesDAO: MovieDAO

    companion object {
        @Volatile
        private var INSTANCE: MoviesDB? = null

        fun getInstance(context: Context): MoviesDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext, MoviesDB::class.java, "movies_db"
                    ).build()
                }

                INSTANCE = instance

                return instance
            }
        }
    }
}