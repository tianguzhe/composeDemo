package com.example.studydemo.ui

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.studydemo.model.NavigationItem
import com.example.studydemo.ui.navigation.Destinations
import com.example.studydemo.ui.screens.NavHostApp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val navigationItems = listOf(
    NavigationItem("学习", Destinations.StudyScreen.route, Icons.Filled.Home),
    NavigationItem("任务", Destinations.TaskScreen.route, Icons.Filled.DateRange),
    NavigationItem("我的", Destinations.MineScreen.route, Icons.Filled.Person),
)

@Composable
fun MainFrame() {
    val navController = rememberNavController()
    var showBottomBar by remember {
        mutableStateOf(true)
    }

    // 沉浸状态栏
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    SideEffect {
        systemUiController.setStatusBarColor(Color.Transparent, darkIcons = useDarkIcons)
    }

    Scaffold(bottomBar = {
        if (showBottomBar) {
            BottomNav(navController = navController)
        }
    }) { innerPadding ->
        NavHostApp(
            modifier = Modifier.padding(innerPadding),
            onChangeBottomNavState = { bottomNavState ->
                showBottomBar = bottomNavState
            },
            navController = navController,
        )
    }
}

@Composable
fun BottomNav(
    navController: NavHostController = rememberNavController(),
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.navigationBarsPadding(),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        navigationItems.forEach { screen ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null,
                    )
                },
                label = { Text(text = screen.item) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color(0xFF999999),
            )
        }
    }
}
