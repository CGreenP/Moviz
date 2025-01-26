package com.example.moviz.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviz.retrofit.Movie

/**
 * [MoviesDB] is the Room database class for the movies application.
 *
 * It defines the database schema, entities, and the data access objects (DAOs).
 *
 * This database contains a single table:
 *   - [Movie]: Represents a movie entity with its properties.
 *
 * It also uses a TypeConverter to handle complex data types.
 *
 * @property moviesDAO The Data Access Object for the [Movie] entity, providing methods to interact with the database.
 *
 * @see Movie
 * @see MovieDAO
 * @see Converters
 */
@Database(entities = [Movie::class], version = 1, exportSchema = false)
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