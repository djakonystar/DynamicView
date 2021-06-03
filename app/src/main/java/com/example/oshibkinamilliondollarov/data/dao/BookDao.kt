package com.example.oshibkinamilliondollarov.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.oshibkinamilliondollarov.data.model.ThemeModel
import com.example.oshibkinamilliondollarov.data.model.Content

@Dao
interface BookDao {
    @Query("SELECT * FROM themes")
    fun getAllData() : List<ThemeModel>

    @Query("SELECT * FROM theme_texts WHERE theme_id=:id")
    fun getTextByThemeId(id: Int) : Content

}