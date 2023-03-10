package com.example.studydemo.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studydemo.mock.MovieItem
import com.example.studydemo.network.RetrofitFactory
import com.example.studydemo.services.MovieService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private var page = 0
    private val pageSize = 50

    private val _movieData = MutableStateFlow<List<MovieItem>>(emptyList())
    val movieData = _movieData.asStateFlow()

    init {
        viewModelScope.launch {
            _movieData.value = RetrofitFactory.instance.createService(MovieService::class.java)
                .getMovieForStart(page * pageSize).items
        }
    }

    fun loadMore() {
        page++
        viewModelScope.launch {
            _movieData.value = mutableListOf<MovieItem>().apply {
                addAll(_movieData.value)
            }.apply {
                addAll(
                    RetrofitFactory.instance.createService(MovieService::class.java)
                        .getMovieForStart(page * pageSize).items,
                )
            }
        }
    }
}
