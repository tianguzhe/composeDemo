package com.example.studydemo.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StudyViewModel : ViewModel() {
    private val _categories = MutableStateFlow<List<String>>(
        listOf(
            "思想政治",
            "法律法规",
            "职业道德",
            "诚信自律",
        ),
    )

    val categories = _categories.asStateFlow()

    private var _categoryIndex = MutableStateFlow<Int>(0)
    val categoryIndex = _categoryIndex.asStateFlow()

    fun updateCategoryIndex(index: Int) {
        _categoryIndex.value = index
    }
}
