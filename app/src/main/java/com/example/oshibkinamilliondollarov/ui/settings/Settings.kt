package com.example.oshibkinamilliondollarov.ui.settings

import android.content.Context

class Settings(private val context: Context) {

    private val prefs = context.getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
    var textSize : Float
    set(value) = prefs.edit().putFloat("textSize", value).apply()
    get() = prefs.getFloat("textSize", 16f)

}