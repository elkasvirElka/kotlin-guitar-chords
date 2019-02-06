package com.example.evira.mysongsapp.songList

import android.util.Log
import com.example.evira.mysongsapp.App

class SongListService(private val listener: SongListView) {
    fun getAllSongs() {

        val db = App.getInsta()!!.getDatabase()
        val data = db!!.employeeDao().getAll()
        listener.setSongList(data)
    }
}