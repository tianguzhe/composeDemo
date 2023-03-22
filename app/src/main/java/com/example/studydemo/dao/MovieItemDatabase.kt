package com.example.studydemo.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.studydemo.MyApp
import com.example.studydemo.mock.MovieItem
import com.example.studydemo.mock.RatingConverter

@Database(
    entities = [MovieItem::class],
    version = 1,
)
@TypeConverters(RatingConverter::class)
abstract class MovieItemDatabase : RoomDatabase() {
    abstract fun movieItemDao(): MovieItemDao

    companion object {
        @Volatile
        private var instance: MovieItemDatabase? = null

        fun getInstance(context: Context = MyApp.instance): MovieItemDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MovieItemDatabase {
            return Room.databaseBuilder(context, MovieItemDatabase::class.java, "movie_db").build()
        }
    }
}
