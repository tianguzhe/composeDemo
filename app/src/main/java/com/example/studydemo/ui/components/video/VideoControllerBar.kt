package com.example.studydemo.ui.components.video

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.studydemo.utils.formatTime

@Composable
fun VideoControllerBar(showControllerBar: Boolean, vodController: VodController) {
    if (showControllerBar) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(1.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(
                    Color(0, 0, 0, 50),
                ).padding(horizontal = 8.dp),
            ) {
                IconButton(onClick = {
                    if (vodController.vodDetail.state == PlayState.Playing) {
                        vodController.pausePlay()
                    } else {
                        vodController.resumePlay()
                    }
                }) {
                    if (vodController.vodDetail.state == PlayState.Playing) {
                        Icon(
                            imageVector = Icons.Default.Pause,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Slider(
                    value = vodController.vodDetail.playProgress,
                    onValueChange = {
                        // TODO 这是需要防抖处理 只处理最后一次的视频跳转
                        vodController.vodDetail.playProgress = it
                        vodController.seekTo(it / 1000)
                    },
                    modifier = Modifier.weight(1f),
                    valueRange = 0f..vodController.vodDetail.playDuration,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${vodController.vodDetail.playProgress.formatTime()} / ${vodController.vodDetail.playDuration.formatTime()}",
                    color = Color.White,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Fullscreen,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    }
}
