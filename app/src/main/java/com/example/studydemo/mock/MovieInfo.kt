package com.example.studydemo.mock

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.studydemo.single.moshi
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Types

@Keep
@JsonClass(generateAdapter = true)
data class MovieData(
    @Json(name = "subject_collection_items")
    @ColumnInfo(name = "subject_collection_items")
    val items: List<MovieItem>,
)

@Keep
@Entity(tableName = "movie_item")
@JsonClass(generateAdapter = true)
data class MovieItem(
    val rating: Rating,
    val pic: Pic,
    val uri: String,
    @Json(name = "card_subtitle")
    @ColumnInfo(name = "card_subtitle")
    val cardSubtitle: String,
    @PrimaryKey val id: String,
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

class RatingConverter {

    private val ratingAdapter: JsonAdapter<Rating> = moshi.adapter(Rating::class.java)
    private val picAdapter: JsonAdapter<Pic> = moshi.adapter(Pic::class.java)
    private val listStringAdapter: JsonAdapter<List<String>> = moshi.adapter<List<String>>(
        Types.newParameterizedType(
            List::class.java,
            String::class.java,
        ),
    )

    @TypeConverter
    fun toRating(value: String): Rating? {
        return ratingAdapter.fromJson(value)
    }

    @TypeConverter
    fun fromRating(value: Rating?): String {
        return ratingAdapter.toJson(value)
    }

    @TypeConverter
    fun toPic(value: String): Pic? {
        return picAdapter.fromJson(value)
    }

    @TypeConverter
    fun fromPic(value: Pic?): String {
        return picAdapter.toJson(value)
    }

    @TypeConverter
    fun toList(value: String): List<String>? {
        return listStringAdapter.fromJson(value)
    }

    @TypeConverter
    fun fromList(value: List<String>?): String {
        return listStringAdapter.toJson(value)
    }
}
