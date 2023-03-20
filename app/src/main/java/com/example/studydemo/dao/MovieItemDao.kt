package com.example.studydemo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studydemo.mock.MovieItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieItemDao {
    @Query("SELECT * FROM movie_item")
    fun getAllMovieDao(): Flow<List<MovieItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(data: List<MovieItem>)

    @Query("DELETE FROM movie_item")
    suspend fun deleteAll()
}
