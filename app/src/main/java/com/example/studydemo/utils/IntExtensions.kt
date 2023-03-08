package com.example.studydemo.utils

/**
 * page 无线轮播算法
 *
 * */
fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

/**
 * 视频毫秒时间转成格式化时间
 *
 * */
fun Float.formatTime(): String {
    val millionSeconds = 1000
    val seconds = 60

    return String.format(
        "%02d:%02d",
        (this / millionSeconds / seconds).toInt(),
        (this / millionSeconds % seconds).toInt(),
    )
}
