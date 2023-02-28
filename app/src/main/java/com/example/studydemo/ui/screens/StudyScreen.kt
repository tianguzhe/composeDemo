package com.example.studydemo.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun StudyScreen() {
    Text(text = "学习页", fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun StudyScreenPreview() {
    Text(text = "学习页", fontSize = 30.sp)
}
