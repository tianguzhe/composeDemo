package com.example.studydemo.ui.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studydemo.local.LocalUserDetail
import com.example.studydemo.ui.components.AppBar
import com.example.studydemo.ui.screens.viewmodel.MineViewModel

@Composable
fun MineScreen(vm: MineViewModel = viewModel()) {
    val localUserViewModel = LocalUserDetail.current
    val userName by localUserViewModel.userName.collectAsStateWithLifecycle()

    Column {
        AppBar {
            Text("我来组成头部", color = Color.White, fontSize = 20.sp)
        }

        BoxWithConstraints(modifier = Modifier.fillMaxSize().weight(1f)) {
            Text(text = constraints.maxHeight.toString())
            Text(text = "\n" + maxHeight.toString())
            Text(text = "\n" + "\n" + constraints.maxWidth.toString())
            Text(text = "\n" + "\n" + "\n" + maxWidth.toString())
        }

        Text(text = userName)
    }
}
