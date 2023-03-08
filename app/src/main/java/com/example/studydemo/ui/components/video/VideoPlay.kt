package com.example.studydemo.ui.components.video

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.studydemo.ui.components.navite.VideoView
import java.util.Timer
import java.util.TimerTask

@Composable
fun VideoPlay(vodController: VodController) {
    var showControllerBar by remember { mutableStateOf(false) }

    var timer: Timer? = null

    Box(
        modifier = Modifier.clickable(
            indication = null,
            interactionSource = remember {
                MutableInteractionSource()
            },
        ) {
            timer?.cancel()
            timer = null
            if (!showControllerBar) {
                timer = Timer().apply {
                    schedule(
                        object : TimerTask() {
                            override fun run() {
                                showControllerBar = false
                            }
                        },
                        3000,
                    )
                }
            }
            showControllerBar = !showControllerBar
        },
    ) {
        VideoView(vodController.vodPlayer)
        VideoControllerBar(showControllerBar = showControllerBar, vodController = vodController)
    }
}
