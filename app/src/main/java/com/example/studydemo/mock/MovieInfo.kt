package com.example.studydemo.mock

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class MovieData(
    @Json(name = "subject_collection_items") val items: List<MovieItem>,
)

@Keep
@JsonClass(generateAdapter = true)
data class MovieItem(
    val rating: Rating,
    val pic: Pic,
    val uri: String,
    @Json(name = "card_subtitle") val cardSubtitle: String,
    val id: String,
    val title: String,
    val description: String,
    val photos: List<String>,
)

@Keep
@JsonClass(generateAdapter = true)
data class Rating(
    val value: Float,
)

@Keep
@JsonClass(generateAdapter = true)
data class Pic(
    val large: String,
    val normal: String,
)
