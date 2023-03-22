package com.example.studydemo.ui.screens.viewmodel

import android.util.Log
import com.example.studydemo.mock.MovieItem
import com.example.studydemo.network.RequestState
import com.example.studydemo.network.RetrofitFactory
import com.example.studydemo.services.MovieService

class TaskViewModelRepository {

    private val movieService = RetrofitFactory.instance.createService(MovieService::class.java)

    private val pageSize = 50

    suspend fun getMovieForStart(start: Int): RequestState<List<MovieItem>> {
        return transformApi {
            movieService.getMovieForStart(start * pageSize).items
        }
    }
}

// TODO 接口返回格式不通用 先临时构造一个格式 List<T>
suspend fun <T> transformApi(block: suspend () -> List<T>): RequestState<List<T>> {
    return try {
        val resp = block.invoke()
        if (resp.isNotEmpty()) {
            RequestState.Success(resp)
        } else {
            RequestState.Error(Throwable("接口错误"))
        }
    } catch (e: Exception) {
        Log.e("TaskViewModelRepository", "${e.message}")
        RequestState.Error(e)
    }
}
