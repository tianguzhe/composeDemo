package com.example.studydemo.startup.task

import android.content.Context
import android.util.Log
import com.example.studydemo.startup.Initializer
import com.tencent.rtmp.TXLiveBase
import com.tencent.rtmp.TXLiveBaseListener

class TencentPlayInit : Initializer<Unit> {
    override fun create(context: Context) {
        val licenceURL =
            "https://license.vod2.myqcloud.com/license/v2/1254022038_1/v_cube.license" // 获取到的 licence url

        val licenceKey = "5bdec42da45028180911f3b44baa7cf2" // 获取到的 licence key

        TXLiveBase.getInstance().setLicence(context, licenceURL, licenceKey)
        TXLiveBase.setListener(object : TXLiveBaseListener() {
            override fun onLicenceLoaded(result: Int, reason: String) {
                Log.i("TAG", "onLicenceLoaded: result:$result, reason:$reason")
            }
        })
    }

    override fun dependencies(): Set<Class<out Initializer<*>>> = setOf(NetworkInit::class.java)
}
