package com.example.oshibkinamilliondollarov.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "theme_texts")
data class Content(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "text")
    val text: String?,
    @ColumnInfo(name = "theme_id")
    val themeId: Int,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Int
)