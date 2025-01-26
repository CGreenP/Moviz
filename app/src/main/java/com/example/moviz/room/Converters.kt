package com.example.moviz.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Converters class provides methods to convert complex data types to and from
 * types that can be stored in a Room database.
 *
 * This class uses Gson library to handle JSON serialization and deserialization.
 */
class Converters {
    @TypeConverter
    fun fromGenreIds(value: List<Long>): String {
        // Convert List<Long> to a JSON string
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toGenreIds(value: String): List<Long> {
        // Convert JSON string back to List<Long>
        val listType = object : TypeToken<List<Long>>() {}.type
        return Gson().fromJson(value, listType)
    }

}