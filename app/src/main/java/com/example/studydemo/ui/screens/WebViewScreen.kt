package com.example.studydemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.studydemo.ui.components.AppBar

@Composable
fun WebViewScreen(url: String) {
    Column {
        AppBar {
            Text(url, color = Color.White, fontSize = 20.sp)
        }
    }
}
