package com.example.studydemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studydemo.ui.components.AppBar
import com.example.studydemo.ui.components.CircleRing
import com.example.studydemo.ui.screens.viewmodel.MineViewModel

@Composable
fun MineScreen(vm: MineViewModel = viewModel()) {
    val num by vm.num.collectAsStateWithLifecycle()

    Column {
        AppBar {
            Text("我来组成头部", color = Color.White, fontSize = 20.sp)
        }
        Text(text = "$num", fontSize = 30.sp)
        CircleRing(100, 30)
        CircleRing(100, 70)
    }
}
