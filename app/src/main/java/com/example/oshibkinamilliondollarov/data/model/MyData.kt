package com.example.oshibkinamilliondollarov.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "themes")
data class MyData(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="description")
    val description: String?

)