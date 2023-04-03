package com.example.studydemo.startup.task

import android.content.Context
import com.example.studydemo.network.RetrofitFactory
import com.example.studydemo.startup.Initializer

class NetworkInit : Initializer<Unit> {
    override fun create(context: Context) {
        RetrofitFactory.instance.setup(
            "https://m.douban.com/rexxar/api/v2/",
        )
    }

    override fun dependencies(): Set<Class<out Initializer<*>>> = emptySet()
}
