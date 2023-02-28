package com.example.studydemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.studydemo.model.NavigationItem

val navigationItems = listOf(
    NavigationItem("学习", Icons.Filled.Home),
    NavigationItem("任务", Icons.Filled.DateRange),
    NavigationItem("我的", Icons.Filled.Person),
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainFrame() {
    var currentNavigationIndex by remember { mutableStateOf(0) }

    Scaffold(bottomBar = {
        BottomNav(
            currentNavigationIndex = currentNavigationIndex,
            onChangeCurrent = { currentNavigationIndex = it },
        )
    }) {
        when (currentNavigationIndex) {
            0 -> StudyScreen()
            1 -> TaskScreen()
            2 -> MineScreen()
        }
    }
}

@Composable
fun BottomNav(currentNavigationIndex: Int, onChangeCurrent: (Int) -> Unit) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.surface,
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
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = Color(0xFF999999),
            )
        }
    }
}
