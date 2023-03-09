package com.example.studydemo.local

import androidx.compose.runtime.compositionLocalOf

val LocalUserDetail = compositionLocalOf<LocalUserViewModel> {
    error("Not Found")
}
