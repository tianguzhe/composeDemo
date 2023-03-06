package com.example.studydemo.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val item: String,
    val route: String,
    val icon: ImageVector,
)
