package com.example.studydemo.mock

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieData(
    @SerializedName("subject_collection_items") val items: List<MovieItem>,
)

@Keep
data class MovieItem(
    val rating: Rating,
    val pic: Pic,
    val uri: String,
    @SerializedName("card_subtitle") val cardSubtitle: String,
    val id: String,
    val title: String,
    val description: String,
    val photos: List<String>,
)

@Keep
data class Rating(
    val value: Float,
)

@Keep
data class Pic(
    val large: String,
    val normal: String,
)
