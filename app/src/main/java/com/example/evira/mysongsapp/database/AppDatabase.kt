package com.example.evira.mysongsapp.database

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.example.evira.mysongsapp.models.Song
import com.example.evira.mysongsapp.models.SongDao


@Database(entities = [Song::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeeDao(): SongDao
}