package com.example.studydemo.ui.components.navite

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.tencent.rtmp.TXVodPlayer
import com.tencent.rtmp.ui.TXCloudVideoView

@Composable
fun VideoView(mVodPlayer: TXVodPlayer) {
    AndroidView(
        factory = { context ->
            TXCloudVideoView(context).also {
                mVodPlayer.setPlayerView(it)
            }
        },
    )
}

