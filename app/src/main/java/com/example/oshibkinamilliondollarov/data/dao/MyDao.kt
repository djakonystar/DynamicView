package com.example.oshibkinamilliondollarov.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.oshibkinamilliondollarov.data.model.MyData

@Dao
interface MyDao {
    @Query("SELECT * FROM themes")
    fun getAllData() : List<MyData>

}