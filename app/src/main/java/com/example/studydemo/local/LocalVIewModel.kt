package com.example.studydemo.local

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studydemo.datastore.UserStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocalUserViewModel(context: Context) : ViewModel() {

    private val userStore = UserStore(context = context)

    private val _userName = MutableStateFlow<String>("giao 桑")
    val userName = _userName.asStateFlow()

    fun save(userName: String) {
        viewModelScope.launch {
            userStore.save(userName)
        }
    }

    init {
        viewModelScope.launch {
            userStore.getStoreForUserName().collect {
                _userName.value = it
            }
        }
    }
}
