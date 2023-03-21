package com.example.studydemo.ui.screens.viewmodel

import android.util.Log
import com.example.studydemo.mock.MovieItem
import com.example.studydemo.network.RetrofitFactory
import com.example.studydemo.services.MovieService

class TaskViewModelRepository {

    private val movieService = RetrofitFactory.instance.createService(MovieService::class.java)

    private val pageSize = 50

    suspend fun getMovieForStart(start: Int): List<MovieItem> {
        return try {
            movieService.getMovieForStart(start * pageSize).items
        } catch (e: Exception) {
            Log.e("TaskViewModelRepository", "${e.message}")
            emptyList()
        }
    }
}
