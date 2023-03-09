package com.example.studydemo.ui.screens

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studydemo.ui.components.AppBar
import com.example.studydemo.ui.components.video.VideoPlay
import com.example.studydemo.ui.components.video.rememberVodController
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewNavigator
import com.google.accompanist.web.rememberWebViewState

@Composable
fun WebViewScreen(urlId: String) {
    Column {
        AppBar {
            Text(urlId, color = Color.White, fontSize = 20.sp)
        }

        val vodPlayerController = rememberVodController()

        DisposableEffect(key1 = vodPlayerController) {
            val videoUrl = "http://vfx.mtime.cn/Video/2019/03/13/mp4/190313094901111138.mp4"
            vodPlayerController.setStartTime(55F)
            vodPlayerController.startPlay(videoUrl)

            onDispose {
                vodPlayerController.stopPlay()
            }
        }

        Box(Modifier.height(200.dp)) {
            VideoPlay(vodController = vodPlayerController)
        }

        val state = rememberWebViewState(url = "https://movie.douban.com/subject/$urlId/")
        val navigator = rememberWebViewNavigator()
        val loadingState = state.loadingState
        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth(),
            )
        }

        val webClient = remember {
            object : AccompanistWebViewClient() {
                override fun onPageStarted(
                    view: WebView?,
                    url: String?,
                    favicon: Bitmap?,
                ) {
                    super.onPageStarted(view, url, favicon)
                    Log.d("Accompanist WebView", "Page started loading for $url")
                }
            }
        }

        WebView(
            state = state,
            modifier = Modifier.weight(1f),
            navigator = navigator,
            onCreated = { webView ->
                webView.settings.javaScriptEnabled = true
            },
            client = webClient,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}
