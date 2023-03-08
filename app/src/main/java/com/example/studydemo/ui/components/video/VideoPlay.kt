package com.example.studydemo.ui.components.video

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.studydemo.ui.components.navite.VideoView
import java.util.Timer
import java.util.TimerTask

@Composable
fun VideoPlay(vodController: VodController) {
    var showControllerBar by remember { mutableStateOf(false) }

    var timer: Timer? = null

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = vodController) {
        val lifecycleEventObserver = LifecycleEventObserver { source, event ->
            when (event) {
                // 切换到前台
                Lifecycle.Event.ON_RESUME -> {
                    Log.d("=====VideoPlay", "Lifecycle.Event.ON_RESUME")
                }

                // 切换到后台
                Lifecycle.Event.ON_PAUSE -> {
                    Log.d("=====VideoPlay", "Lifecycle.Event.ON_PAUSE")
                }

                else -> {}
            }
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleEventObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleEventObserver)
        }
    }

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
