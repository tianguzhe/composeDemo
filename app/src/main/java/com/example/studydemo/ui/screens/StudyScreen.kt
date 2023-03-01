package com.example.studydemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.studydemo.ui.components.AppBar

@Composable
fun StudyScreen() {
    Column {
        AppBar {
            Text(text = "学习页", fontSize = 30.sp)
        }
//        Image(painter = , contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun StudyScreenPreview() {
    Text(text = "学习页", fontSize = 30.sp)
}
