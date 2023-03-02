package com.example.studydemo.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import com.example.studydemo.mock.MovieData
import com.example.studydemo.mock.MovieRepo
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel : ViewModel() {
    private val _movieData = MutableStateFlow<MovieData>(
        Gson().fromJson(MovieRepo.filter0To50, MovieData::class.java),
    )

    val movieData = _movieData.asStateFlow()
}
