package com.example.studydemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.studydemo.ui.components.AppBar

@Composable
fun MineScreen() {
    Column {
        AppBar {
            Text("我来组成头部", color = Color.White, fontSize = 20.sp)
        }
        Text(text = "我的页", fontSize = 30.sp)
    }
}
