package com.example.studydemo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studydemo.ui.navigation.Destinations

@Composable
fun NavHostApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.StudyScreen.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(Destinations.StudyScreen.route) {
            StudyScreen()
        }

        composable(Destinations.TaskScreen.route) {
            TaskScreen(onNavigateToWebView = {
                navController.navigate(Destinations.WebViewScreen.route)
            })
        }

        composable(Destinations.MineScreen.route) {
            MineScreen()
        }

        composable(
            Destinations.WebViewScreen.route,
        ) {
            WebViewScreen()
        }
    }
}
