package com.example.oshibkinamilliondollarov.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.oshibkinamilliondollarov.data.dao.BookDao
import com.example.oshibkinamilliondollarov.data.model.ThemeModel
import com.example.oshibkinamilliondollarov.data.model.Content

@Database(entities = [ThemeModel::class, Content::class], version = 1)
abstract class BookDatabase: RoomDatabase() {

    companion object {
        private lateinit var INSTANCE: BookDatabase
        fun getInstance(context: Context): BookDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    BookDatabase::class.java,
                    "MyBook.db"
                )
                    .createFromAsset("MyBook.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

    }

    abstract fun dao(): BookDao
}