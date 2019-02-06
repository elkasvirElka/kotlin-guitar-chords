package ru.sarmatin.autoapp

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val STORAGE_NAME = "prefs_auto_app"
    val settings: SharedPreferences = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = settings.edit()

}