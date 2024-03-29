package com.example.studydemo.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studydemo.mock.MovieItem
import com.example.studydemo.network.RequestState
import com.example.studydemo.network.doSuccess
import com.example.studydemo.single.movieDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TaskViewModel(
    private val taskViewModelRepository: TaskViewModelRepository = TaskViewModelRepository(),
) : ViewModel() {
    private var page = 0

    private val _movieData =
        MutableStateFlow<RequestState<List<MovieItem>>>(RequestState.Loading).also { movieDateAlso ->
            viewModelScope.launch {
                movieDao.getAllMovieDao().collectLatest {
                    movieDateAlso.value = RequestState.Success(it)
                }
            }
        }

    val movieData = _movieData.asStateFlow()

    init {
        injectRoomData()
    }

    fun loadMore() {
        page++
        injectRoomData()
    }

    private fun injectRoomData() {
        viewModelScope.launch {
            val items = taskViewModelRepository.getMovieForStart(page)

            items.doSuccess {
                movieDao.insertMovie(it)
            }
        }
    }
}
