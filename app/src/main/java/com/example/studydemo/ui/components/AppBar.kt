package com.example.studydemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 通用appbar
 *
 * */
@Composable
fun AppBar(content: @Composable () -> Unit) {
    val barHeight = 56.dp

    Column(
        modifier = Modifier.background(
            Brush.linearGradient(
                listOf(Color(0xFF5EFCE8), Color(0xFF736EFE)),
            ),
        ),
    ) {
        Spacer(
            modifier = Modifier.windowInsetsTopHeight(WindowInsets.statusBars).fillMaxWidth(),
        )
        Row(
            modifier = Modifier.height(barHeight).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar {
        Text("TopTitle", color = Color.White, fontSize = 30.sp)
    }
}
