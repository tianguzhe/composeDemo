package com.example.studydemo.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MineViewModel : ViewModel() {
    private val _num = MutableStateFlow<Int>(0)

    val num = _num.asStateFlow()
}
