package com.example.studydemo.ui.components.video

import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.tencent.rtmp.ITXVodPlayListener
import com.tencent.rtmp.TXLiveConstants
import com.tencent.rtmp.TXVodPlayer

class VodController(context: Context) {

    val vodDetail = VodDetail()

    val vodPlayer = TXVodPlayer(context).apply {
        setVodListener(object : ITXVodPlayListener {
            override fun onPlayEvent(player: TXVodPlayer?, event: Int, param: Bundle) {
                when (event) {
                    TXLiveConstants.PLAY_EVT_PLAY_LOADING -> {
                        vodDetail.state = PlayState.Loading
                    }

                    TXLiveConstants.PLAY_EVT_VOD_PLAY_PREPARED,
                    TXLiveConstants.PLAY_EVT_RCV_FIRST_I_FRAME,
                    TXLiveConstants.PLAY_EVT_VOD_LOADING_END,
                    TXLiveConstants.PLAY_EVT_PLAY_BEGIN,
                    -> {
                        vodDetail.state = PlayState.Playing
                    }

                    TXLiveConstants.PLAY_EVT_PLAY_PROGRESS -> {
                        // 加载进度, 单位是毫秒
                        val playable_duration_ms: Int =
                            param.getInt(TXLiveConstants.EVT_PLAYABLE_DURATION_MS)
                        vodDetail.playableDuration = playable_duration_ms.toFloat()

                        // 播放进度, 单位是毫秒
                        val progress_ms: Int = param.getInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS)
                        vodDetail.playProgress = progress_ms.toFloat()

                        // 视频总长, 单位是毫秒
                        val duration_ms: Int = param.getInt(TXLiveConstants.EVT_PLAY_DURATION_MS)
                        vodDetail.playDuration = duration_ms.toFloat()
                    }
                }
            }

            override fun onNetStatus(p0: TXVodPlayer?, p1: Bundle?) {
            }
        })
    }

    fun startPlay(url: String) {
        vodPlayer.startVodPlay(url)
    }

    fun stopPlay() {
        vodPlayer.stopPlay(true); // true 代表清除最后一帧画面
    }

    fun resumePlay() {
        vodPlayer.resume()
    }

    fun pausePlay() {
        vodDetail.state = PlayState.Pause
        vodPlayer.pause()
    }

    fun setStartTime(pos: Float) {
        vodPlayer.setStartTime(pos)
    }

    fun seekTo(time: Float) {
        vodPlayer.seek(time)
    }
}

@Composable
fun rememberVodController(context: Context = LocalContext.current) = remember {
    VodController(context)
}
