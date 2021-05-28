package com.example.oshibkinamilliondollarov.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "theme_texts" )
data class ThemeTextsData(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "text")
    val text: String,
    @PrimaryKey
    val theme_id: Int,
    @PrimaryKey
    val is_favorite: Int

)