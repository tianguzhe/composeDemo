package com.example.studydemo

import android.app.Application
import android.util.Log
import com.example.studydemo.network.RetrofitFactory
import com.tencent.rtmp.TXLiveBase
import com.tencent.rtmp.TXLiveBaseListener

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val licenceURL =
            "https://license.vod2.myqcloud.com/license/v2/1254022038_1/v_cube.license" // 获取到的 licence url

        val licenceKey = "5bdec42da45028180911f3b44baa7cf2" // 获取到的 licence key

        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey)
        TXLiveBase.setListener(object : TXLiveBaseListener() {
            override fun onLicenceLoaded(result: Int, reason: String) {
                Log.i("TAG", "onLicenceLoaded: result:$result, reason:$reason")
            }
        })

        RetrofitFactory.instance.setup(
            "https://m.douban.com/rexxar/api/v2/",
        )
    }
}
