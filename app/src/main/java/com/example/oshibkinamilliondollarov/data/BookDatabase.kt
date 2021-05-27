package com.example.oshibkinamilliondollarov.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.oshibkinamilliondollarov.data.dao.MyDao
import com.example.oshibkinamilliondollarov.data.model.MyData


@Database(entities = [MyData::class], version = 1)
abstract class BookDatabase: RoomDatabase() {

    companion object {
        private lateinit var INSTANCE: BookDatabase
        fun getInstance(context: Context): BookDatabase =
        Room.databaseBuilder(
            context,
            BookDatabase::class.java,
            "MyBook.db"
        )
            .createFromAsset("MyBook.db")
            .allowMainThreadQueries()
            .build()
    }

    abstract fun dao(): MyDao

}