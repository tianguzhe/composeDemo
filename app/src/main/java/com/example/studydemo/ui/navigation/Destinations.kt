package com.example.studydemo.ui.navigation

sealed class Destinations(val route: String) {

    object StudyScreen : Destinations("StudyScreen")
    object TaskScreen : Destinations("TaskScreen")
    object MineScreen : Destinations("MineScreen")

    object WebViewScreen : Destinations("WebViewScreen")
}
