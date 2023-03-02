package com.example.studydemo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studydemo.ui.components.AppBar
import com.example.studydemo.ui.screens.viewmodel.StudyViewModel

@Composable
fun StudyScreen(vm: StudyViewModel = viewModel()) {
    val categories by vm.categories.collectAsStateWithLifecycle()
    val categoryIndex by vm.categoryIndex.collectAsStateWithLifecycle()

    Column {
        AppBar {
            Text(text = "学习页", fontSize = 30.sp)
        }
        RowItem(categories, categoryIndex) { index ->
            vm.updateCategoryIndex(index)
        }
    }
}

@Composable
fun RowItem(categories: List<String>, categoryIndex: Int, onClick: (Int) -> Unit) {
    TabRow(
        selectedTabIndex = categoryIndex,
        backgroundColor = Color(0x0F149EE7),
        contentColor = Color(0xFF149EE7),
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = categoryIndex == index,
                onClick = { onClick(index) },
                selectedContentColor = Color(0xFF149EE7),
                unselectedContentColor = Color(0xFF666666),
            ) {
                Text(
                    text = category,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 16.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyScreenPreview() {
    Text(text = "学习页", fontSize = 30.sp)
}
