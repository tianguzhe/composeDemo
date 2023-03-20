package com.example.studydemo.single

import com.example.studydemo.dao.MovieItemDatabase
import com.squareup.moshi.Moshi

val moshi: Moshi = Moshi.Builder().build()

val movieDao = MovieItemDatabase.getInstance().movieItemDao()
