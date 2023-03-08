package com.example.studydemo.ui.components.video

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class VodDetail {

    // 播放状态
    var state by mutableStateOf(PlayState.Loading)

    // 加载进度
    var playableDuration by mutableStateOf(0f)

    // 播放进度
    var playProgress by mutableStateOf(0f)

    // 视频总长
    var playDuration by mutableStateOf(0f)
}

enum class PlayState {
    Loading, Playing, Pause
}
