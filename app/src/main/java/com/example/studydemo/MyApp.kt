package com.example.studydemo

import android.app.Application
import com.example.studydemo.startup.AppInitializer
import com.example.studydemo.startup.task.NetworkInit
import com.example.studydemo.startup.task.TencentPlayInit
import com.example.studydemo.utils.notNullSingle
import kotlin.properties.Delegates

class MyApp : Application() {

    companion object {
        var instance by Delegates.notNullSingle<MyApp>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        AppInitializer.getInstance(this)
            .addTask(TencentPlayInit())
            .addTask(NetworkInit())
            .build(debug = true)
    }
}
