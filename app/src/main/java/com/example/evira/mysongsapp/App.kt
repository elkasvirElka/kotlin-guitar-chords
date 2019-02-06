package com.example.evira.mysongsapp

import android.app.Application
//import io.realm.Realm
//import io.realm.RealmConfiguration
import ru.sarmatin.autoapp.Prefs
import android.arch.persistence.room.Room
import com.example.evira.mysongsapp.database.AppDatabase


class App : Application() {


    companion object {
        private var database: AppDatabase? = null
        var instance: App? = null

        var prefs: Prefs? = null
        fun setString(name: String, value: String) {
            prefs?.editor?.putString(name, value)
            prefs?.editor?.apply()
        }

        fun getString(name: String): String? {
            return prefs?.settings?.getString(name, "")
        }

        fun getInsta(): App? {
            return instance
        }

    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)

        instance = this
        database = Room.databaseBuilder<AppDatabase>(
            this,
            AppDatabase::class.java,
            "database"
        ).allowMainThreadQueries().build()


    }

    fun getDatabase(): AppDatabase? {
        return database
    }
/*
    fun getInstance(): App? {
        return instance
    }*/


}