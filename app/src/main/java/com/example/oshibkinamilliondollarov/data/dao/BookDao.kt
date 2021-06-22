package com.example.oshibkinamilliondollarov.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.oshibkinamilliondollarov.data.model.ThemeModel

@Dao
interface BookDao {
    @Query("SELECT * FROM themes")
    fun getAllData() : List<ThemeModel>

    @Query("SELECT * FROM themes WHERE id=:id")
    fun getTextByThemeId(id: Int) : ThemeModel

    @Query("SELECT * FROM themes WHERE is_favorite=1")
    fun getFavoriteThemes() : List<ThemeModel>

    @Update
    fun updateTheme(theme: ThemeModel)

}