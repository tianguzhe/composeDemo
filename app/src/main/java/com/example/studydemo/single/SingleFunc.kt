package com.example.studydemo.single

import android.content.pm.ApplicationInfo
import com.example.studydemo.MyApp
import com.example.studydemo.dao.MovieItemDatabase
import com.squareup.moshi.Moshi

val moshi: Moshi = Moshi.Builder().build()

val movieDao = MovieItemDatabase.getInstance().movieItemDao()

/**
 * 判断是否在debug环境
 *
 * */
val isDebugEnv: Boolean
    get() {
        return try {
            val info: ApplicationInfo = MyApp.instance.applicationInfo
            info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
        } catch (e: Exception) {
            false
        }
    }
