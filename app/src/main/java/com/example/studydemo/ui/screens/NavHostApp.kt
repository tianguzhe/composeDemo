package com.example.studydemo.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.studydemo.ui.navigation.Destinations

@Composable
fun NavHostApp(
    modifier: Modifier = Modifier,
    onChangeBottomNavState: (Boolean) -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.StudyScreen.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable(Destinations.StudyScreen.route) {
            onChangeBottomNavState(true)
            StudyScreen()
        }

        composable(Destinations.TaskScreen.route) {
            onChangeBottomNavState(true)
            TaskScreen(onNavigateToWebView = { route ->
                navController.navigate(route)
            })
        }

        composable(Destinations.MineScreen.route) {
            onChangeBottomNavState(true)
            MineScreen()
        }

        composable(
            Destinations.WebViewScreen.route,
            arguments = listOf(navArgument("url") { type = NavType.StringType }),
        ) { backStackEntry ->
            onChangeBottomNavState(false)
            WebViewScreen(
                url = backStackEntry.arguments?.getString("url") ?: "Web页面",
            )
        }
    }
}
