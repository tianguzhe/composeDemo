package com.example.studydemo.services

import com.example.studydemo.mock.MovieData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieService {
    @Headers(
        "Referer: https://m.douban.com/subject_collection/movie_top250",
        "Host: m.douban.com",
        "Cookie: bid=bIuF253OZnY",
        "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.0.0",
    )
    @GET("subject_collection/movie_top250/items")
    suspend fun getMovieForStart(
        @Query("start") start: Int,
        @Query("count") count: Int = 50,
        @Query("items_only") items_only: Int = 1,
        @Query("for_mobile") for_mobile: Int = 1,
    ): MovieData
}
