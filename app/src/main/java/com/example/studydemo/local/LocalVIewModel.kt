package com.example.studydemo.local

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LocalUserViewModel : ViewModel() {
    private val _userName = MutableStateFlow<String>("giao 桑")
    val userName = _userName.asStateFlow()
}
