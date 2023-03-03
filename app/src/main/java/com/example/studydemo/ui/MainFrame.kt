package com.example.studydemo.ui

import androidx.compose.foundation.layout.Box
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
import com.example.studydemo.model.NavigationItem
import com.example.studydemo.ui.screens.MineScreen
import com.example.studydemo.ui.screens.StudyScreen
import com.example.studydemo.ui.screens.TaskScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val navigationItems = listOf(
    NavigationItem("学习", Icons.Filled.Home),
    NavigationItem("任务", Icons.Filled.DateRange),
    NavigationItem("我的", Icons.Filled.Person),
)

@Composable
fun MainFrame() {
    var currentNavigationIndex by remember { mutableStateOf(0) }

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    SideEffect {
        systemUiController.setStatusBarColor(Color.Transparent, darkIcons = useDarkIcons)
    }

    Scaffold(bottomBar = {
        BottomNav(
            currentNavigationIndex = currentNavigationIndex,
            onChangeCurrent = { currentNavigationIndex = it },
        )
    }) {
        Box(modifier = Modifier.padding(it)) {
            when (currentNavigationIndex) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }
    }
}

@Composable
fun BottomNav(currentNavigationIndex: Int, onChangeCurrent: (Int) -> Unit) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.navigationBarsPadding(),
    ) {
        navigationItems.forEachIndexed { index, navigationItem ->
            BottomNavigationItem(
                selected = currentNavigationIndex == index,
                onClick = { onChangeCurrent(index) },
                icon = {
                    Icon(
                        imageVector = navigationItem.icon,
                        contentDescription = null,
                    )
                },
                label = { Text(text = navigationItem.item) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color(0xFF999999),
            )
        }
    }
}
